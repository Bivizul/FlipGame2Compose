package aaa.admin.flipgame2compose.ui

import aaa.admin.flipgame2compose.ui.theme.ColorGaflimco
import aaa.admin.flipgame2compose.ui.theme.ColorGaflimct
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Gaflimame(
    modifier: Modifier = Modifier
) {
    var state by remember { mutableStateOf(CardFace.Front) }

    var score by remember { mutableStateOf(0) }

    Surface(modifier.fillMaxSize()) {
        Column(
            modifier = modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(text = "Earnings on click in the screen")
            Text(text = "Your money : $score $")

            FlipCard(
                modifier = modifier.size(250.dp),
                cardFace = state,
                onClick = {
                    score++
                    state = it.next
                },
                axis = RotationAxis.AxisY,
                back = {
                    Text(
                        text = "Green", Modifier
                            .fillMaxSize()
                            .background(Color.Green),
                        color = Color.White
                    )
                },
                front = {
                    Text(
                        text = "Cyan", Modifier
                            .fillMaxSize()
                            .background(Color.Cyan),
                        color = Color.White
                    )
                }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewGaflimame() {
    Gaflimame()
}

enum class CardFace(val angle: Float) {

    Front(0f) {
        override val next: CardFace
            get() = Back
    },
    Back(180f) {
        override val next: CardFace
            get() = Front
    };

    abstract val next: CardFace
}

enum class RotationAxis {
    AxisX,
    AxisY,
}

@ExperimentalMaterialApi
@Composable
fun FlipCard(
    cardFace: CardFace,
    onClick: (CardFace) -> Unit,
    modifier: Modifier = Modifier,
    axis: RotationAxis = RotationAxis.AxisY,
    back: @Composable () -> Unit = {},
    front: @Composable () -> Unit = {},
) {
    val rotation = animateFloatAsState(
        targetValue = cardFace.angle,
        animationSpec = tween(
            durationMillis = 400,
            easing = FastOutSlowInEasing,
        )
    )
    Card(
        onClick = { onClick(cardFace) },
        modifier = modifier
            .graphicsLayer {
                if (axis == RotationAxis.AxisX) {
                    rotationX = rotation.value
                } else {
                    rotationY = rotation.value
                }
                cameraDistance = 12f * density
            },
    ) {
        if (rotation.value <= 90f) {
            Box(
                Modifier.fillMaxSize()
            ) {
                front()
            }
        } else {
            Box(
                Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        if (axis == RotationAxis.AxisX) {
                            rotationX = 180f
                        } else {
                            rotationY = 180f
                        }
                    },
            ) {
                back()
            }
        }
    }
}

