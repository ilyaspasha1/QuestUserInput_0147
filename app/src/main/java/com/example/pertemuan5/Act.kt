package com.example.pertemuan5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pertemuan5.ui.theme.Pertemuan5Theme

@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    //variable -variable untuk mengingat nilai masukan dari keyboard
    var textNma by remember { mutableStateOf("") }
    var textAlmat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    //variable - variable untuk menyimpan data yang diperoleh dari komponen ui
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    val gender: List<String> = listOf(
        "Laki-laki",
        "Perempuan"
    )

    Column(
        modifier = modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNma,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { textNma = it }
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            gender.forEach { item ->
                Row(
                    modifier = Modifier.selectable(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    )
                    Text(text = item)
                }
            }
        }

        OutlinedTextField(
            value = textAlmat,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text(text = "Alamat") },
            onValueChange = { textAlmat = it }
        )

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            enabled = textNma.isNotEmpty() && textAlmat.isNotEmpty(),
            onClick = {
                nama = textNma
                alamat = textAlmat
                jenis = textJK
            }
        ) {
            Text(stringResource(id = R.string.Submit))
        }

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = "Nama : $nama", color = Color.White)
                Text(text = "Gender : $jenis", color = Color.White)
                Text(text = "Alamat : $alamat", color = Color.White)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActFormDataDiriPreview() {
    Pertemuan5Theme {
        FormDataDiri()
    }
}
