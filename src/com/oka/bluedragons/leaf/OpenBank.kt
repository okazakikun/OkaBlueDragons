package com.oka.bluedragons.leaf

import com.oka.bluedragons.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.rt4.Camera
import org.powbot.api.rt4.Movement
import org.powbot.api.script.tree.Leaf

class OpenBank(script: Script) : Leaf<Script>(script, "opening bank") {
    override fun execute() {
        if (Bank.inViewport()) {
            Bank.open()
        } else {
            Movement.moveToBank()
            Camera.turnTo(Bank.nearest().tile())
        }
    }
}