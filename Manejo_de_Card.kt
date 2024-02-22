package com.mexiti.listacomida

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mexiti.listacomida.data.DataSource
import com.mexiti.listacomida.model.Platillo
import com.mexiti.listacomida.ui.theme.ListaComidaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListaComidaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MenuApp()

                }
            }
        }
    }
}
@Composable
fun MenuApp(){
    MenuCardList(
        platilloList = DataSource().LoadPlatillos(),
    )
}

@Composable
fun MenuCardList( platilloList:List<Platillo>, modifier: Modifier = Modifier ){
    LazyColumn( modifier = modifier ){
        items(platilloList){
            platillo -> MenuCard(
            platillo = platillo,
                modifier= Modifier.padding(10.dp)
        )
        }

    }
}



@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier){
    Card(modifier = Modifier) {
        Column  {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(id = platillo.drawableResourceId),
                    contentDescription = stringResource(id = platillo.stringResourceId),
                    modifier = Modifier
                        .size(170.dp,170.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = LocalContext.current.getString(platillo.stringResourceId),
                    modifier = Modifier.padding(22.dp),
                    style = MaterialTheme.typography.displayMedium
                )
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun MenuPlatilloPreview() {
    ListaComidaTheme {
        MenuCard(platillo = Platillo(R.string.pozole,R.drawable.pozole) )
    }
}
