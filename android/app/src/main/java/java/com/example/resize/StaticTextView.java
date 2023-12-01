package com.example.resize;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.platform.PlatformView;
import java.util.Map;
import java.util.Random;

class StaticTextView implements PlatformView {
  private final String TAG = "StaticTextView";
  @NonNull
  private final TextView textView;
  private int id;
  private int clickCount = 0;

  StaticTextView(@NonNull Context context, int id, @Nullable Map<String, Object> creationParams) {
    this.id = id;
    textView = new TextView(context);
    textView.setTextSize(20);
    textView.setTextColor(Color.BLACK);
    textView.setBackgroundColor(0xFF0000FF);
    textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

    int count = 0;
    StringBuilder sb = new StringBuilder();
    sb.append("Static Text View (id: " + id + ")\n");
    sb.append(" " + clickCount + " ");
    clickCount++;
    textView.setText(sb.toString());
    

    textView.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
          
          StringBuilder sb = new StringBuilder();
          sb.append("Static Text View (id: " + id + ")\n");
          sb.append(" " + clickCount + " ");
          clickCount++;
          textView.setText(sb.toString());
        }
        Log.e(TAG, "#onTouch " + event.getAction());
        return false;
      }
    });
  }

  @NonNull
  @Override
  public View getView() {
    return textView;
  }

  @Override
  public void dispose() {
    Log.e(TAG, "#StaticTextView#dispose~~ id=" + id);
  }
}

class StaticTextViewFactory extends PlatformViewFactory {
  StaticTextViewFactory() {
    super(StandardMessageCodec.INSTANCE);
  }

  @NonNull
  @Override
  public PlatformView create(@NonNull Context context, int id, @Nullable Object args) {
    final Map<String, Object> creationParams = (Map<String, Object>) args;
    return new StaticTextView(context, id, creationParams);
  }
}
