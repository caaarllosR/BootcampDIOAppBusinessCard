package br.com.dio.businesscard.util

import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import top.defaults.colorpicker.ColorPickerPopup


class ColorPicker() : AppCompatActivity()  {
    companion object {

        private var selectedColorPicker = Color.DKGRAY

        val returSelectedColor: () -> Int = { selectedColorPicker }

        fun testColorPicker(viewPreview: ViewPager, v : View, appCompatActivity: AppCompatActivity) {
                ColorPickerPopup.Builder(appCompatActivity).initialColor(
                    Color.RED
                ) // set initial color
                    // of the color
                    // picker dialog
                    .enableBrightness(
                        true
                    ) // enable color brightness
                    // slider or not
                    .enableAlpha(
                        true
                    ) // enable color alpha
                    // changer on slider or
                    // not
                    .okTitle(
                        "ESCOLHER"
                    ) // this is top right
                    // Choose button
                    .cancelTitle(
                        "CANCELAR"
                    ) // this is top left
                    // Cancel button which
                    // closes the
                    .showIndicator(
                        true
                    ) // this is the small box
                    // which shows the chosen
                    // color by user at the
                    // bottom of the cancel
                    // button
                    .showValue(
                        false
                    ) // this is the value which
                    // shows the selected
                    // color hex code
                    // the above all values can be made
                    // false to disable them on the
                    // color picker dialog.
                    .build()
                    .show(
                        v,
                        object : ColorPickerPopup.ColorPickerObserver() {
                            override fun onColorPicked(color: Int) {

                                // now as soon as
                                // the dialog closes
                                // set the preview
                                // box to returned
                                // color
                                selectedColorPicker = color
                                viewPreview?.setBackgroundColor(color)
                            }
                        })
            }
        }
}
