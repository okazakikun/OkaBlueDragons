package com.oka.bluedragons.leaf.bankopened

import com.oka.bluedragons.Script
import org.powbot.api.rt4.Bank
import org.powbot.api.script.tree.Leaf

class CloseBank(script: Script) : Leaf<Script>(script, "Closing bank") {
    override fun execute() {
        Bank.close()
    }
}
