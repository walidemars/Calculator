package com.nikitinsky.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    modifier: Modifier = Modifier,
) {
    val symbols = listOf("√", "π", "^", "!",
        "AC", "()", "%", "÷",
        "7", "8", "9", "X",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ",", "=")
    val rows = symbols.chunked(4)

    Column(
        modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 40.dp,
                bottomEnd = 40.dp
            ))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .weight(1f)
            .padding(bottom = 16.dp, start = 40.dp, end = 40.dp),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = "45*8",
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = "360",
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        rows.forEachIndexed { rowsIndex, rowsStr ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                rowsStr.forEachIndexed { index, symbol ->
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                when (rowsIndex) {
                                    0 -> MaterialTheme.colorScheme.background
                                    1 -> if (index == 0) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.tertiary
                                    else -> if (index == rowsStr.lastIndex) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
                                }
                            )
                            .aspectRatio(if (rowsIndex == rows.lastIndex) {
                                if (index == 0) 2 / 1f
                                else 1f
                            } else 1f)
                            .weight(when(rowsIndex) {
                                5 -> if (index == 0) 2f else 1f
                                else -> 1f
                            }),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = symbol,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            fontSize = (when (rowsIndex) {
                                0 -> 30.sp
                                1 -> if (index == 0) 35.sp else 40.sp
                                else -> 40.sp
                            }),
                            fontWeight = if (rowsIndex == 0) FontWeight.SemiBold else FontWeight.Normal
                        )
                    }
                }
            }
        }
    }
}