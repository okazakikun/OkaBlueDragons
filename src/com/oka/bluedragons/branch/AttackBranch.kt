package com.oka.bluedragons.branch

import com.oka.bluedragons.Constants
import com.oka.bluedragons.Constants.AREA_DRAGON_SPAWN
import com.oka.bluedragons.Constants.ID_DRAGON
import com.oka.bluedragons.Script
import com.oka.bluedragons.leaf.AttackDragon
import com.oka.bluedragons.leaf.Chill
import org.powbot.api.Area
import org.powbot.api.Tile
import org.powbot.api.rt4.Actor
import org.powbot.api.rt4.Npcs
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Branch
import org.powbot.api.script.tree.TreeComponent

class DragonCheck(script: Script) : Branch<Script>(script, "Dragon there") {
    override val successComponent: TreeComponent<Script> = AttackingCheck(script)
    override val failedComponent: TreeComponent<Script> = Chill(script)

    override fun validate(): Boolean {
        val dragon = Npcs.stream().id(ID_DRAGON).nearest().first()
        return AREA_DRAGON_SPAWN.contains(dragon.tile()) && dragon.animation() != 92
    }
}

class AttackingCheck(script: Script) : Branch<Script>(script, "already attacking?") {
    override val successComponent: TreeComponent<Script> = AttackDragon(script)
    override val failedComponent: TreeComponent<Script> = Chill(script)

    override fun validate(): Boolean {
        val dragon = Npcs.stream().id(ID_DRAGON).nearest().first()
        val dragonTile = Npcs.stream().id(ID_DRAGON).nearest().first().tile()
        Constants.AREA_DRAGON = Area( Tile(dragonTile.x + 2,dragonTile.y + 2), Tile(dragonTile.x - 2, dragonTile.y - 2))
        return Players.local().interacting() != dragon || dragon.interacting() == Actor.Nil
    }
}