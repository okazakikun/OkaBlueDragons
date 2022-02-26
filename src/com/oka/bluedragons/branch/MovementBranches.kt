package com.oka.bluedragons.branch

import com.oka.bluedragons.Constants.AREA_DRAGON_SPAWN
import com.oka.bluedragons.Constants.AREA_DUNGEON
import com.oka.bluedragons.Constants.ID_DRAGON
import com.oka.bluedragons.Constants.ID_LOOT
import com.oka.bluedragons.Constants.TILE_LOOT
import com.oka.bluedragons.Constants.TILE_SAFESPOT
import com.oka.bluedragons.Script
import com.oka.bluedragons.leaf.PickupLoot
import com.oka.bluedragons.leaf.WalkToSafespot
import com.oka.bluedragons.leaf.Webwalktosafespot
import org.powbot.api.rt4.GroundItems
import org.powbot.api.rt4.Inventory
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent


class FullInv(script: Script) : Branch<Script>(script, "Full inv?") {
    override val successComponent: TreeComponent<Script> = InFally(script)
    override val failedComponent: TreeComponent<Script> = LootCheck(script)

    override fun validate(): Boolean {
        return Inventory.isFull()
    }
}

class LootCheck(script: Script) : Branch<Script>(script, "Looting") {
    override val successComponent: TreeComponent<Script> = PickupLoot(script)
    override val failedComponent: TreeComponent<Script> = ShouldMove(script)

    override fun validate(): Boolean {
        val dragon = Npcs.stream().id(ID_DRAGON).nearest().first()
        return GroundItems.stream().id(*ID_LOOT).at(TILE_LOOT)
            .isNotEmpty() && !AREA_DRAGON_SPAWN.contains(dragon.tile())
    }
}

class ShouldMove(script: Script) : Branch<Script>(script, "At safespot?") {
    override val successComponent: TreeComponent<Script> = DragonCheck(script)
    override val failedComponent: TreeComponent<Script> = InCave(script)

    override fun validate(): Boolean {
        return Players.local().tile() == TILE_SAFESPOT
    }
}

class InCave(script: Script) : Branch<Script>(script, "in the dungeon?") {
    override val successComponent: TreeComponent<Script> = WalkToSafespot(script)
    override val failedComponent: TreeComponent<Script> = Webwalktosafespot(script)

    override fun validate(): Boolean {
        return AREA_DUNGEON.contains(Players.local().tile())
    }
}