package com.example.walkee;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BarGraph extends View {

    private int barsCount;
    private int[] barValues;
    private int barColor;
    private int selectedMonthIndex = -1; // Initialize with no month selected

    public BarGraph(Context context, AttributeSet attrs) {
        super(context, attrs);
        barValues = new int[0]; // Initialize with empty array
    }

    public void setBarsCount(int count) {
        barsCount = count;
        barValues = new int[barsCount];
    }

    public void setBarsColor(int color) {
        barColor = color;
    }

    public void setBarValue(int index, int value) {
        if (index >= 0 && index < barsCount) {
            barValues[index] = value;
            invalidate(); // Refresh view
        }
    }

    public void setSelectedMonth(int monthIndex) {
        selectedMonthIndex = monthIndex;
        invalidate(); // Refresh view
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (barsCount == 0) {
            return;
        }

        int monthsCount = getResources().getStringArray(R.array.Months).length - 1; // Exclude "Todos" option
        float barWidth = getWidth() / (float) monthsCount;

        Paint paint = new Paint();
        paint.setColor(barColor);
        paint.setStyle(Paint.Style.FILL);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(50);
        textPaint.setTextAlign(Paint.Align.CENTER);

        // Calculate max value for scaling
        int maxValue = getMaxValue();

        for (int i = 0; i < barsCount; i++) {
            if (selectedMonthIndex != -1 && i != selectedMonthIndex) {
                continue; // Skip drawing other months if a month is selected
            }

            float left = i * barWidth;
            float top = getHeight() * (1 - (float) barValues[i] / maxValue);
            float right = left + barWidth;
            float bottom = getHeight();
            canvas.drawRect(left, top, right, bottom, paint);

            // Draw month name and amount vertically centered
            String monthName = getResources().getStringArray(R.array.Months)[i + 1]; // Adjust index for "Todos" option
            String amountText = String.format("$%,d", barValues[i]); // Format amount as currency
            String text = monthName + "  " + amountText;

            canvas.save();
            canvas.rotate(-90, left + (right - left) / 2, getHeight() / 2);
            canvas.drawText(text, left + (right - left) / 2, getHeight() / 2, textPaint);
            canvas.restore();
        }
    }

    private int getMaxValue() {
        int max = 0;
        for (int value : barValues) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
