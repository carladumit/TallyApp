package com.carladumit.tallyapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.carladumit.tallyapp.*

@Composable
fun InputField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    password: Boolean = false,
    passwordVisible: Boolean = false,
    onTogglePassword: (() -> Unit)? = null
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .border(
                        width = 1.dp,
                        color = BorderColor,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(horizontal = 12.dp),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                color = BorderColor,
                                fontSize = 16.sp
                            )
                        }

                        BasicTextField(
                            value = value,
                            onValueChange = onValueChange,
                            singleLine = true,
                            textStyle = TextStyle(
                                fontSize = 16.sp,
                                color = TextColor
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = keyboardType
                            ),
                            visualTransformation = if (
                                password && !passwordVisible
                            ) {
                                PasswordVisualTransformation()
                            } else {
                                VisualTransformation.None
                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    if (password && onTogglePassword != null) {
                        Text(
                            text = if (passwordVisible) "◉" else "◎",
                            fontSize = 16.sp,
                            color = BorderColor,
                            modifier = Modifier
                                .clickable(onClick = onTogglePassword)
                                .padding(start = 8.dp)
                        )
                    }
                }
            }

            Text(
                text = label,
                fontSize = 16.sp,
                color = BorderColor,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .background(ScreenColor)
                    .padding(horizontal = 1.dp)
                    .align(Alignment.TopStart)
            )
        }
    }
}
