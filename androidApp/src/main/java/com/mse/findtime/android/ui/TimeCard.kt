package com.mse.findtime.android.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Preview
@Composable
fun TimeCard( timezone:String="ACT",hours:Double=8.0,time:String="04:55 PM",date:String="Wednesday, September 6"){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp).padding(16.dp).background(color = Color.Green)
    ){
        Card(
            shape = RoundedCornerShape(8.dp),
            border= BorderStroke(1.dp, color = Color.Gray),
            modifier = Modifier.fillMaxWidth()
        )
        {
            Box(modifier = Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp))
            {
                Row (modifier = Modifier.fillMaxWidth()) {
                    Column(horizontalAlignment = Alignment.Start) {
                        Text(text = timezone, style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold
                        )
                        )
                        Spacer(modifier = Modifier.weight(1.0f))
                        Row {
                            Text(text = hours.toString(), style = MaterialTheme.typography.labelSmall.copy(
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.onPrimaryContainer

                            ))

                            Text(text =" hours from local", style = MaterialTheme.typography.labelSmall.copy(
                                color = MaterialTheme.colorScheme.onPrimaryContainer,

                            ) )

                        }

                        
                    }
                    Spacer(modifier = Modifier.weight(1.0f))
                    Column(horizontalAlignment = Alignment.End) {
                        Text(text = time, style = MaterialTheme.typography.titleMedium.copy(

                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontWeight = FontWeight.Bold

                        )
                        )
                        Spacer(modifier = Modifier.weight(1.0f))
                        Text(text =date, style = MaterialTheme.typography.labelSmall.copy(
                            color = MaterialTheme.colorScheme.onPrimaryContainer,

                        ) )
                    }
                    
                }
            }


        }
    }
}