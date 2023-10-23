package com.recepgemalmaz.pazarama_bootcamp_ders_3_compose_1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.recepgemalmaz.pazarama_bootcamp_ders_3_compose_1.ui.theme.Pazarama_Bootcamp_Ders_3_Compose_1Theme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pazarama_Bootcamp_Ders_3_Compose_1Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScr()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScr() {

    var activity = LocalContext.current as Activity

    var userName = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier
        .fillMaxHeight()
        .background(Color.Cyan)
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        TextField(value = userName.value,
            leadingIcon =
            {
                Icon(imageVector = Icons.Default.Face , contentDescription = "UserName")
            },
            onValueChange = {
                userName.value = it
            },
            singleLine = true,
            placeholder =
            {
                Text(text = activity.resources.getString(R.string.user))
            }
        )
        Spacer(Modifier.padding(15.dp))

        TextField(value = password.value,
            leadingIcon =
            {
                Icon(imageVector = Icons.Default.Warning , contentDescription = "Password")
            },
            onValueChange = {
                password.value = it
            },
            singleLine = true,
            placeholder =
            {
                Text(text = activity.getString(R.string.pass))
            }
        )
        Spacer(Modifier.padding(15.dp))

        Button(onClick = {

            if (!userName.value.isNullOrEmpty() && !password.value.isNullOrEmpty())
            {
                if (userName.value.equals("admin") && password.value.equals("xyz123"))
                {
                    var other = Intent(activity, OtherActivity::class.java)

                    other.putExtra("unm", "Yönetici")

                    activity.startActivity(other)
                }
                else
                {
                    Toast.makeText(activity, R.string.err, Toast.LENGTH_LONG).show()
                }
            }
            else
            {
                Toast.makeText(activity, "İsim ve/veya şifre hatalı!", Toast.LENGTH_LONG).show()
            }

        }) {
            Text(text = "Giriş")
        }

        Spacer(Modifier.padding(15.dp))

        Button(onClick = {
            activity.finish()
        }) {
            Text(text = "Vazgeç")
        }

    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pazarama_Bootcamp_Ders_3_Compose_1Theme {
        MainScr()
    }
}