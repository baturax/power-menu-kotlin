package power.menu
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "touchME",
            resizable = false,
            transparent = true,
            undecorated = true,
            state = WindowState(width = 300.dp, height = 155.dp)
        ) {
            Surface(
                color = Color.Transparent,
            ) {
                App()
            }
        }
}