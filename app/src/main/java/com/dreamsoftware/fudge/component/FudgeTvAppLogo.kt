package com.dreamsoftware.fudge.component

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.tv.material3.MaterialTheme

@Composable
fun FudgeTvAppLogo(
    modifier: Modifier = Modifier,
    @DrawableRes appLogoRes: Int,
    @StringRes titleRes: Int,
    @StringRes subtitleRes: Int,
    textColor: Color = MaterialTheme.colorScheme.onPrimary,
    largeMode: Boolean = true
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {

        Image(
            painter = painterResource(id = appLogoRes),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxHeight()
        )

        Spacer(modifier = Modifier.width(8.dp))

        Spacer(
            modifier = Modifier
                .width(1.dp)
                .fillMaxHeight()
                .background(textColor)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier.padding(horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FudgeTvText(
                type = if (largeMode) {
                    FudgeTvTextTypeEnum.HEADLINE_MEDIUM
                } else {
                    FudgeTvTextTypeEnum.TITLE_LARGE
                },
                titleRes = titleRes,
                textBold = true,
                textColor = textColor
            )

            Spacer(modifier = Modifier.height(2.dp))

            FudgeTvText(
                type = if (largeMode) {
                    FudgeTvTextTypeEnum.HEADLINE_SMALL
                } else {
                    FudgeTvTextTypeEnum.TITLE_MEDIUM
                },
                titleRes = subtitleRes,
                textColor = textColor
            )
        }
    }
}