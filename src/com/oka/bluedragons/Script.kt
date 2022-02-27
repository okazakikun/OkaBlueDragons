package com.oka.bluedragons


import com.oka.bluedragons.Constants.ID_LOOT
import com.oka.bluedragons.branch.IsBankOpened
import org.powbot.api.Color
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.ScriptCategory
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import org.powbot.mobile.service.ScriptUploader
import java.util.logging.Logger

@ScriptManifest(
    name = "OkaBlueDragons",
    description = "Kills blue dragons for bones+hide.",
    version = "0.0.1",
    category = ScriptCategory.MoneyMaking,
    author = "Okazaki"
)

class Script : TreeScript() {
    private val logger = Logger.getLogger(this.javaClass.name)

    override val rootComponent: TreeComponent<*> by lazy {
        IsBankOpened(this)
    }

    override fun onStart() {
        super.onStart()
        addPaint()
    }

    private fun addPaint() {
        val p: Paint = PaintBuilder.newBuilder()
            .addString("Last leaf:") { lastLeaf.name }
            .trackInventoryItems(*ID_LOOT)
            .trackSkill(Skill.Ranged)
            .trackSkill(Skill.Magic)
            .backgroundColor(Color.argb(255, 117, 124, 168))
            .build()
        addPaint(p)
    }
}

fun main(args: Array<String>) {
    ScriptUploader().uploadAndStart("OkaBlueDragons", "", "127.0.0.1:5605", true, false)
}