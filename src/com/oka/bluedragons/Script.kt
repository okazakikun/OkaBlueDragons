package com.oka.bluedragons


import com.google.common.eventbus.Subscribe
import com.oka.bluedragons.Constants.ID_LOOT
import com.oka.bluedragons.branch.IsBankOpened
import com.oka.bluedragons.Constants.AREA_DRAGON
import org.powbot.api.Area
import org.powbot.api.Color
import org.powbot.api.Tile
import org.powbot.api.event.RenderEvent
import org.powbot.api.rt4.walking.model.Skill
import org.powbot.api.script.ScriptCategory
import org.powbot.api.script.ScriptManifest
import org.powbot.api.script.paint.Paint
import org.powbot.api.script.paint.PaintBuilder
import org.powbot.api.script.tree.TreeComponent
import org.powbot.api.script.tree.TreeScript
import org.powbot.mobile.service.ScriptUploader
import java.util.logging.Logger
import org.powbot.api.rt4.Npcs

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

//    @Subscribe
//    fun onRenderEvent(e: RenderEvent) {
//        val g = e.graphics
//        g.setScale(1.0f)
//        if (AREA_DRAGON != null) {
//            val TILES_DRAGON = AREA_DRAGON!!.tiles
//            for (item in TILES_DRAGON)
//                item.drawOnScreen(g)
//        }
//        // do all your drawing in here
//    }
}

fun main(args: Array<String>) {
    ScriptUploader().uploadAndStart("OkaBlueDragons", "", "127.0.0.1:5605", true, false)
}