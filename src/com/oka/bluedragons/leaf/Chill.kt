package com.oka.bluedragons.leaf

import com.oka.bluedragons.Script
import org.powbot.api.Condition
import org.powbot.api.script.tree.Leaf

class Chill(script: Script) : Leaf<Script>(script, "Chillin") {
    override fun execute() {
        Condition.sleep()
    }
}