package mx.unam.fi.certificadocurso

import android.media.Image
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.unam.fi.certificadocurso.ui.theme.CertificadoCursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CertificadoCursoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CertificateCourse("Arturo Misael Capulín Ornelas ")
                }
            }
        }
    }
}

@Composable
fun CertificateCourse(name: String, modifier: Modifier = Modifier) {
    Row(horizontalArrangement = Arrangement.SpaceAround,
        modifier= modifier.fillMaxSize().padding(10.dp)) {
        Image(painter= painterResource(id = R.drawable.logounam),
            contentDescription= null,
            //contentScale = ContentScale.Fit,
            modifier=modifier
                .size(50.dp,50.dp)
        )
        //Column {
        Text(
            text = "Universidad Nacional\n Autónoma de México",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Center,

        )

        Image(painter= painterResource(id = R.drawable.escudo_fi_color),
            contentDescription= null,
            modifier=modifier
                .size(55.dp,55.dp)

        )
    }


    Column (modifier = modifier
        .fillMaxSize()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center){

        Text(
            text = "\n\nFacultad de ingenieria",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                //.padding(60.dp)
                .fillMaxWidth()
        )

        Text(
            text = "\nEste certificado es presentado a:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
        )

        Box(contentAlignment = Alignment.Center, modifier = modifier.fillMaxWidth())
        {
            Image(painter= painterResource(id = R.drawable.androidlogo),
                contentDescription= null,
                modifier=modifier.fillMaxWidth(),
                alpha = 0.4f
            )

            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = modifier
                    .fillMaxWidth()
            )
        }
    Column{
    Text(text = "Ha completado de manera exitosa 2 horas del curso en:",
        fontSize = 12.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .fillMaxWidth())

        Text(
            text = "Manejo de Android",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth())
    }

        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically,
            modifier= modifier.fillMaxSize().padding(10.dp)){
            Column{
                Image(painter= painterResource(id = R.drawable.firma1),
                    contentDescription= null,
                    contentScale = ContentScale.Fit,
                    modifier=modifier
                        .size(90.dp)
                        //.fillMaxWidth()
                )
                Text(
                    text = "Mauricio Hernandez",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    /*modifier = modifier
                        .fillMaxWidth()*/

                )
                Text(
                    text = "Director",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    /*modifier = modifier
                        .fillMaxWidth()*/
                )
            }
            Column{
                Image(painter= painterResource(id = R.drawable.firma2),
                    contentDescription= null,
                    contentScale = ContentScale.Fit,
                    modifier=modifier
                        .size(90.dp)
                        //.fillMaxWidth()
                )
                Text(
                    text = "Arturo Capulín",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()

                )
                Text(
                    text = "Representante",
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = modifier
                        .fillMaxWidth()
                )
            }
        }
}
}
@Preview(showBackground = true)
@Composable
fun CertificatePreview() {
    CertificadoCursoTheme {
        CertificateCourse("Arturo Misael Capulín Ornelas")
    }
}
