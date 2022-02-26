package com.oka.bluedragons.leaf

import com.oka.bluedragons.Constants.AREA_FALLY
import com.oka.bluedragons.Script
import org.powbot.api.Condition
import org.powbot.api.rt4.Game
import org.powbot.api.rt4.Magic
import org.powbot.api.rt4.Players
import org.powbot.api.script.tree.Leaf

class TeleToFally(script: Script) : Leaf<Script>(script, "Teleporting to Falador") {
    override fun execute() {
        if (Game.tab(Game.Tab.MAGIC) && Magic.Spell.FALADOR_TELEPORT.cast())
            Condition.wait { AREA_FALLY.contains(Players.local().tile()) }
    }
}