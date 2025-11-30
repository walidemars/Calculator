package com.nikitinsky.calculator

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun Calculator(
    modifier: Modifier = Modifier,
    viewModel: CalculatorViewModel = viewModel()
) {
//    val symbols = listOf("√", "π", "^", "!",
//        "AC", "()", "%", "÷",
//        "7", "8", "9", "X",
//        "4", "5", "6", "-",
//        "1", "2", "3", "+",
//        "0", ",", "=")
//    val rows = symbols.chunked(4)

    val state = viewModel.state.collectAsState()

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
                text = state.value.expression,
                fontSize = 36.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Text(
                text = state.value.result,
                fontSize = 17.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
                Text(
                    modifier = Modifier.weight(1f)
                        .clickable {
                            viewModel.processCommand(CalculatorCommand.Input(Symbol.SQRT))
                        },
                    text = "√",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    modifier = Modifier.weight(1f)
                        .clickable {
                            viewModel.processCommand(CalculatorCommand.Input(Symbol.PI))
                        },
                    text = "π",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    modifier = Modifier.weight(1f)
                        .clickable {
                            viewModel.processCommand(CalculatorCommand.Input(Symbol.POWER))
                        },
                    text = "^",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                )
                Text(
                    modifier = Modifier.weight(1f)
                        .clickable {
                            viewModel.processCommand(CalculatorCommand.Input(Symbol.FACTORIAL))
                        },
                    text = "!",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                )
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Clear)
                    }
                    .background(MaterialTheme.colorScheme.secondary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "AC",
                    fontSize = 35.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PARENTHESIS))
                    }
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "()",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.PERCENT))
                    }
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "%",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIVIDE))
                    }
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "÷",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_7))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "7",
                    fontSize = 35.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_8))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "8",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_9))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "9",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.MULTIPLY))
                    }
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "X",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_4))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "4",
                    fontSize = 35.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_5))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "5",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_6))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "6",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.SUBTRACT))
                    }
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "-",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_1))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "1",
                    fontSize = 35.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_2))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "2",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_3))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.ADD))
                    }
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier.weight(2f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DIGIT_0))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(2 / 1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "0",
                    fontSize = 35.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Input(Symbol.DOT))
                    }
                    .background(MaterialTheme.colorScheme.primary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = ",",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            Box(
                modifier = Modifier.weight(1f)
                    .clip(CircleShape)
                    .clickable {
                        viewModel.processCommand(CalculatorCommand.Evaluate)
                    }
                    .background(MaterialTheme.colorScheme.tertiary)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "=",
                    fontSize = 40.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

//        rows.forEachIndexed { rowsIndex, rowsStr ->
//            Row(
//                modifier = Modifier.fillMaxWidth()
//                    .wrapContentHeight(),
//                horizontalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                rowsStr.forEachIndexed { index, symbol ->
//                    Box(
//                        modifier = Modifier
//                            .clip(CircleShape)
//                            .background(
//                                when (rowsIndex) {
//                                    0 -> MaterialTheme.colorScheme.background
//                                    1 -> if (index == 0) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.tertiary
//                                    else -> if (index == rowsStr.lastIndex) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
//                                }
//                            )
//                            .aspectRatio(if (rowsIndex == rows.lastIndex) {
//                                if (index == 0) 2 / 1f
//                                else 1f
//                            } else 1f)
//                            .weight(when(rowsIndex) {
//                                5 -> if (index == 0) 2f else 1f
//                                else -> 1f
//                            }),
//                        contentAlignment = Alignment.Center
//                    ) {
//                        Text(
//                            text = symbol,
//                            color = MaterialTheme.colorScheme.onPrimaryContainer,
//                            fontSize = (when (rowsIndex) {
//                                0 -> 30.sp
//                                1 -> if (index == 0) 35.sp else 40.sp
//                                else -> 40.sp
//                            }),
//                            fontWeight = if (rowsIndex == 0) FontWeight.SemiBold else FontWeight.Normal
//                        )
//                    }
//                }
//            }
//        }
    }
}