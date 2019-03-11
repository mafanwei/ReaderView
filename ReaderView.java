package com.mafanwei;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.regex.Pattern;

/**
 * Created by MaFanwei on 2019/3/3
 */
public class ReaderView extends View {
    private String txt;
    private Paint paint;
    private int rowHeight;
    private int rowSpan;
    private String[] parts;
    private ShowAtListener showAtListener;
  //  private int pages=0;
   // private boolean needFresh;
    public ReaderView(Context context) {
        super(context);
        init();
    }

    public ReaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ReaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void setShowAtListener(ShowAtListener showAtListener) {
        this.showAtListener = showAtListener;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
        Log.i("asdparttxt",txt);
        parts=txt.split("\n");
        invalidate();
    }

    public void setTxt(String[] parts)
    {
        txt="123";
        this.parts=parts;
        invalidate();
    }

    public interface ShowAtListener
    {
        void showAt(int pos);
    }

    private void init()
    {
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLACK);
        paint.setTextSize(Tools.sp2px(getContext(),22));
        paint.setTextAlign(Paint.Align.LEFT);
        txt="";
        inits();
    }

    private void inits()
    {
        Rect rect=new Rect();
        paint.getTextBounds("我，。！ ?",0,6,rect);
        rowHeight=rect.bottom-rect.top;
        rowSpan=Tools.dip2px(getContext(),16);
    }

    public int getRowSpan() {
        return rowSpan;
    }

    public void setRowSpan(int rowSpan) {
        this.rowSpan = rowSpan;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(txt==null||txt.equals(""))
            return;

        int manyRow=getHeight()/(rowHeight+rowSpan);
        int atwhere=0;
        int showoff=0;
        int j=0;
        for(;j<parts.length;j++)
        {
            if(parts[j].equals(""))
            {
                continue;
            }
          //  parts[j]="      "+parts[j];
          //  showoff-=6;
            int oldPos=0;

            for(int i=atwhere;i<manyRow;i++)
            {
                int breadText = paint.breakText(parts[j].substring(oldPos), true, getWidth(),null);
                String mShow=breadText+oldPos<parts[j].length()?parts[j].substring(oldPos,oldPos+breadText):parts[j].substring(oldPos);
                while(oldPos+breadText<parts[j].length())
                {
                    char c=parts[j].charAt(oldPos+breadText);
                    Pattern p=Pattern.compile("\\p{P}");
                    if(p.matcher(c+"").find()&&(c!='“'||c!='"'))
                    {
                        mShow=mShow.substring(0,mShow.length()-1);
                        oldPos--;
                    }
                    else
                        break;
                }
                canvas.drawText(mShow,0,(i+1)*(rowHeight+rowSpan),paint);
                oldPos+=breadText;
                atwhere++;
                if(oldPos>=parts[j].length())
                    break;
            }
            showoff+=oldPos>parts[j].length()?parts[j].length():oldPos;
            if(atwhere>=manyRow)
               break;
        }
        showoff+=j;
       if(showAtListener!=null)
           showAtListener.showAt(showoff);

    }

    public int getRowHeight() {
        return rowHeight+rowSpan;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
        inits();
        invalidate();
    }
}
