package com.aspire.mycomposejetapp

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.aspire.mycomposejetapp.screens.home.prelogin.SetTip
import com.aspire.mycomposejetapp.ui.theme.MyComposeJetAppTheme

class JetTipActivity : ComponentActivity() {
    lateinit var contextV : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeJetAppTheme {

            }
        }
    }
}



fun calculateTotalPerson(sliderPositionVal: Float, context: Context) {

    val intent = Intent(context , MoviesListActivity::class.java)
    context.startActivity(intent)

}

//@Preview(name = "Light Mode")
//@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//fun SetTipPreview() {
//    MyComposeJetAppTheme {
//        SetTip(null)
//    }
//}