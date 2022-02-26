package com.oka.bluedragons.leaf

import com.oka.bluedragons.Constants.ID_LOOT
import com.oka.bluedragons.Constants.TILE_LOOT
import com.oka.bluedragons.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.GroundItems
import org.powbot.api.script.tree.Leaf

class PickupLoot(script: Script) : Leaf<Script>(script, "Picking up loot") {
    override fun execute() {
        val allLoot = GroundItems.stream().id(*ID_LOOT).at(TILE_LOOT)
        val firstLoot = allLoot.first()
        if (firstLoot.inViewport()) {
            val lootCount = allLoot.count()
            if (firstLoot.interact("Take")) {
                Condition.wait { allLoot.count() < lootCount }
            }
        } else Camera.turnTo(firstLoot)

    }
}