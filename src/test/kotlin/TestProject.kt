import io.kotest.core.spec.style.ShouldSpec
import org.gradle.testfixtures.ProjectBuilder
import java.net.URI

class TestProject : ShouldSpec({
    should("run ok") {
        val proj = ProjectBuilder.builder().build()
//        proj.repositories.maven {
//            it.url = URI("../local-plugin-repository")
//        }

        proj.apply {
            it.plugin("com.github.rarebreed.common.kotlin.lib")
        }

    }
})