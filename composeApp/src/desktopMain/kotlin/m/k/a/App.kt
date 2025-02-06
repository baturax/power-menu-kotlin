package m.k.a

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ataturk.composeapp.generated.resources.*
import com.lordcodes.turtle.shellRun
import org.jetbrains.compose.resources.Font

@Composable
fun App() {
    val fantasyFontFamily= FontFamily(
        Font(Res.font.FantasqueSansMono_Bold, FontWeight.Bold),
    )

    Column {
        Row {

            Button(onClick = { rebootPc() }) { Text("Reboot", fontFamily = fantasyFontFamily, fontWeight = FontWeight.Bold) }
            Spacer(modifier = Modifier.size(116.dp))
            Button(onClick = { powerOff() }) { Text("PowerOff", fontFamily = fantasyFontFamily, fontWeight = FontWeight.Bold) }
        }
        Row {
            Button(onClick = { logOut() } ) {Text(text = "LogOut", fontFamily = fantasyFontFamily, fontWeight = FontWeight.Bold)}
            Spacer(modifier = Modifier.size(116.dp))
            Button(onClick = { suspend() } ) {Text(text = "Suspend", fontFamily = fantasyFontFamily, fontWeight = FontWeight.Bold)}

        }
    }

}

fun rebootPc() {
    val rebootText: String = "Will reboot in 3 seconds"
    val notifiaction = shellRun("notify-send", listOf("-a", "system", rebootText))
    val rebootIt = shellRun("sleep", listOf("3s"))
    val finallyover = shellRun("reboot")
}
fun powerOff() {
    val poweroffText: String = "Will shutdown in 3 seconds"
    val notifiaction = shellRun("notify-send", listOf("-a", "system", poweroffText))
    val rebootIt = shellRun("sleep", listOf("3s"))
    val finallyover = shellRun("reboot")
}

fun logOut() {
    val logoutText: String = "Will logout in 3 seconds"
    val notifiaction = shellRun("notify-send", listOf("-a", "system", logoutText))
    val rebootIt = shellRun("sleep", listOf("3s"))
    val logoutIt = ProcessBuilder("kill", "-9", "-1").start()
}

fun suspend() {
    val suspendText: String = "Will suspend in 3 seconds"
    val notifiaction = shellRun("notify-send", listOf("-a", "system", suspendText))
    val rebootIt = shellRun("sleep", listOf("3s"))
    val logoutIt = ProcessBuilder("systemctl", "suspend").start()

}
