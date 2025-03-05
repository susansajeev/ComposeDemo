package com.aspire.mycomposejetapp

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspire.mycomposejetapp.ui.theme.MyComposeJetAppTheme
import kotlinx.coroutines.processNextEventInCurrentThread

class JetTipActivity : ComponentActivity() {
    lateinit var contextV : Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyComposeJetAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SetTip(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SetTip(modifier: Modifier = Modifier, totalPerson: Double = 134.09) {

    var billNo by remember { (mutableStateOf(TextFieldValue(""))) }
    val total = "%.2f".format(totalPerson)
    var context = LocalContext.current
    var sliderPositionVal by remember { mutableStateOf(2f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .clip(RoundedCornerShape(20.dp)),

            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE9D7F7))
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Total per Person",
                    modifier = Modifier,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    "$$total",
                    modifier = Modifier,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                    )
            }


        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(2.dp, Color.LightGray, RectangleShape),

            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(20.dp),

                ) {

                OutlinedTextField(
                    value = billNo,
                    onValueChange = { billNo = it },
                    label = { Text("Enter Bill No") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                )
                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text("Split ")
                    Row(
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        Image(
                            painter = painterResource(R.drawable.add),
                            contentDescription = "",
                            modifier = Modifier.size(25.dp)
                        )
                        Spacer(Modifier.width(20.dp))

                        Text("12 ")

                        Spacer(Modifier.width(20.dp))

                        Image(
                            painter = painterResource(R.drawable.minus),
                            contentDescription = "",
                            modifier = Modifier.size(25.dp)
                        )
                    }


                }

                Spacer(Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text("Tip ")
                    Text("$12.00 ", modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp))

                }

                Text("$sliderPositionVal %", Modifier.align(Alignment.CenterHorizontally))
                Slider(value = sliderPositionVal,
                    onValueChange = {
                        sliderPositionVal = it
                        calculateTotalPerson(sliderPositionVal, context)
                    }, steps = 5

                )
            }


        }
    }
}

fun calculateTotalPerson(sliderPositionVal: Float, context: Context) {

    val intent = Intent(context , MoviesListActivity::class.java)
    context.startActivity(intent)

}

@Preview(name = "Light Mode")
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun SetTipPreview() {
    MyComposeJetAppTheme {
        SetTip()
    }
}