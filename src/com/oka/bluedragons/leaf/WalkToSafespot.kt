package com.oka.bluedragons.leaf

import com.oka.bluedragons.Constants.TILE_SAFESPOT
import com.oka.bluedragons.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Movement
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class WalkToSafespot(script: Script) : Leaf<Script>(script, "Walk to safespot") {
    override fun execute() {
        if (Movement.step(TILE_SAFESPOT))
            Condition.wait { Players.local().tile() == TILE_SAFESPOT }
    }
}