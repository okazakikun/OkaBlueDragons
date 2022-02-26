package com.oka.bluedragons.leaf

import com.oka.bluedragons.Constants.TILE_SAFESPOT
import com.oka.bluedragons.Script
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf

class Webwalktosafespot(script: Script) : Leaf<Script>(script, "Walking to dungeon") {
    override fun execute() {
        Movement.moveTo(TILE_SAFESPOT)
    }
}