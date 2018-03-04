# CustomToggleButton

<h1>Android custom toggle button with Custom font example</h1>
&nbsp;

<img src="http://thoughtnerds.com/wp-content/uploads/2018/03/Android-custom-toggle-button-with-Custom-font-example-300x158.png" alt="Android custom toggle button with Custom font example" width="678" height="357" class=" wp-image-711 aligncenter" />

In this tutorial, we can learn how to customise Toggle Button hold a custom font and can use the Toggle Button in the whole project.

<img src="http://thoughtnerds.com/wp-content/uploads/2018/03/Android-custom-toggle-button-with-Custom-font-example-169x300.jpeg" alt="" width="223" height="396" class="wp-image-707 aligncenter" />

<strong>STEP 1:-</strong>First of all create the<span> </span><strong>Assets Folder</strong><em> </em>if it's not created already, Copy the font you want to use in your project.

<img src="http://thoughtnerds.com/wp-content/uploads/2018/03/Screenshot-73.png" alt="" width="235" height="106" class="alignnone size-full wp-image-697" />

<strong>STEP 2</strong>:- Create an attrs,xml in in <strong>res/values </strong>
<pre><span>&lt;?</span><span>xml version=</span><span>"1.0" </span><span>encoding=</span><span>"utf-8"</span><span>?&gt;
</span><span>&lt;resources&gt;
</span><span>&lt;declare-styleable </span><span>name=</span><span>"CustomToggleButton"</span><span>&gt;
</span><span>    &lt;attr </span><span>name=</span><span>"ct_fontName" </span><span>format=</span><span>"string" </span><span>/&gt;
</span><span>    &lt;attr </span><span>name=</span><span>"ct_draw_left" </span><span>format=</span><span>"reference" </span><span>/&gt;
</span><span>    &lt;attr </span><span>name=</span><span>"ct_draw_right" </span><span>format=</span><span>"reference" </span><span>/&gt;
</span><span>    &lt;attr </span><span>name=</span><span>"ct_draw_top" </span><span>format=</span><span>"reference" </span><span>/&gt;
</span><span>    &lt;attr </span><span>name=</span><span>"ct_draw_bottom" </span><span>format=</span><span>"reference" </span><span>/&gt;
</span><span>    &lt;attr </span><span>name=</span><span>"ct_draw_background" </span><span>format=</span><span>"reference" </span><span>/&gt;
</span><span>    &lt;attr </span><span>name=</span><span>"ct_draw_btn" </span><span>format=</span><span>"reference" </span><span>/&gt;
</span><span></span><span> </span><span>&lt;/resources&gt;</span></pre>
<span></span><span> <img src="http://thoughtnerds.com/wp-content/uploads/2018/03/Screenshot-74.png" alt="" width="242" height="196" class="alignnone size-full wp-image-698" /> </span>
<strong>STEP 3</strong>:- Create a selector in <strong>drawables </strong> bg_button_selector.xml

&nbsp;
<pre><span>&lt;?</span><span>xml version=</span><span>"1.0" </span><span>encoding=</span><span>"utf-8"</span><span>?&gt;
</span><span>&lt;selector </span><span>xmlns:</span><span>android</span><span>=</span><span>"http://schemas.android.com/apk/res/android"</span><span>&gt;
</span><span>    &lt;item </span><span>android</span><span>:drawable=</span><span>"@color/colorPrimary" </span><span>android</span><span>:state_checked=</span><span>"true" </span><span>/&gt;
</span><span>    &lt;item </span><span>android</span><span>:drawable=</span><span>"@color/colorAccent" </span><span>android</span><span>:state_checked=</span><span>"false" </span><span>/&gt;
</span><span>&lt;/selector&gt;</span></pre>
&nbsp;

<strong>STEP 4</strong>:- Create a Java class <span>CustomToggleButton</span><span>.java </span>
<pre><span>public class </span>CustomToggleButton <span>extends </span>ToggleButton <span>implements </span>View.OnClickListener {
    <span>private static final </span>String <span>TAG </span>= <span>"CustomToggleButton"</span><span>;
</span><span>
</span><span>    </span><span>@RequiresApi</span>(<span>api </span>= Build.VERSION_CODES.<span>LOLLIPOP</span>)
    <span>public </span><span>CustomToggleButton</span>(Context context<span>, </span>AttributeSet attrs<span>, int </span>defStyleAttr<span>, int </span>defStyleRes) {
        <span>super</span>(context<span>, </span>attrs<span>, </span>defStyleAttr<span>, </span>defStyleRes)<span>;
</span><span>        if </span>(!isInEditMode()) {
            initAttributes(context<span>, </span>attrs)<span>;
</span><span>        </span>}
    }

    <span>public </span><span>CustomToggleButton</span>(Context context<span>, </span>AttributeSet attrs<span>, int </span>defStyleAttr) {
        <span>super</span>(context<span>, </span>attrs<span>, </span>defStyleAttr)<span>;
</span><span>        if </span>(!isInEditMode()) {
            initAttributes(context<span>, </span>attrs)<span>;
</span><span>        </span>}
    }

    <span>public </span><span>CustomToggleButton</span>(Context context<span>, </span>AttributeSet attrs) {
        <span>super</span>(context<span>, </span>attrs)<span>;
</span><span>        if </span>(!isInEditMode()) {
            initAttributes(context<span>, </span>attrs)<span>;
</span><span>        </span>}
    }

    <span>private void </span><span>initAttributes</span>(Context context<span>, </span>AttributeSet attrs) {
        <span>if </span>(attrs != <span>null</span>) {
            TypedArray attributeArray = getContext().obtainStyledAttributes(attrs<span>, </span>R.styleable.<span>CustomToggleButton</span>)<span>;
</span><span>            </span>Drawable drawableLeft = <span>null;
</span><span>            </span>Drawable drawableRight = <span>null;
</span><span>            </span>Drawable drawableBottom = <span>null;
</span><span>            </span>Drawable drawableTop = <span>null;
</span><span>            if </span>(Build.VERSION.<span>SDK_INT </span>&gt;= Build.VERSION_CODES.<span>LOLLIPOP</span>) {
                drawableLeft = attributeArray.getDrawable(R.styleable.<span>CustomToggleButton_ct_draw_left</span>)<span>;
</span><span>                </span>drawableRight = attributeArray.getDrawable(R.styleable.<span>CustomToggleButton_ct_draw_right</span>)<span>;
</span><span>                </span>drawableBottom = attributeArray.getDrawable(R.styleable.<span>CustomToggleButton_ct_draw_bottom</span>)<span>;
</span><span>                </span>drawableTop = attributeArray.getDrawable(R.styleable.<span>CustomToggleButton_ct_draw_top</span>)<span>;
</span><span>            </span>} <span>else </span>{
                <span>final int </span>drawableLeftId = attributeArray.getResourceId(R.styleable.<span>CustomToggleButton_ct_draw_left</span><span>, </span>-<span>1</span>)<span>;
</span><span>                final int </span>drawableRightId = attributeArray.getResourceId(R.styleable.<span>CustomToggleButton_ct_draw_right</span><span>, </span>-<span>1</span>)<span>;
</span><span>                final int </span>drawableBottomId = attributeArray.getResourceId(R.styleable.<span>CustomToggleButton_ct_draw_bottom</span><span>, </span>-<span>1</span>)<span>;
</span><span>                final int </span>drawableTopId = attributeArray.getResourceId(R.styleable.<span>CustomToggleButton_ct_draw_top</span><span>, </span>-<span>1</span>)<span>;
</span><span>                if </span>(drawableLeftId != -<span>1</span>)
                    drawableLeft = AppCompatResources.<span>getDrawable</span>(getContext()<span>, </span>drawableLeftId)<span>;
</span><span>                if </span>(drawableRightId != -<span>1</span>)
                    drawableRight = AppCompatResources.<span>getDrawable</span>(getContext()<span>, </span>drawableRightId)<span>;
</span><span>                if </span>(drawableBottomId != -<span>1</span>)
                    drawableBottom = AppCompatResources.<span>getDrawable</span>(getContext()<span>, </span>drawableBottomId)<span>;
</span><span>                if </span>(drawableTopId != -<span>1</span>)
                    drawableTop = AppCompatResources.<span>getDrawable</span>(getContext()<span>, </span>drawableTopId)<span>;
</span><span>            </span>}
            String fontName = attributeArray.getString(R.styleable.<span>CustomToggleButton_ct_fontName</span>)<span>;
</span><span>            if </span>(fontName != <span>null</span>) {
                Typeface typeface = Typeface.<span>createFromAsset</span>(getContext().getAssets()<span>, </span><span>"fonts/" </span>+ fontName)<span>;
</span><span>                if </span>(typeface != <span>null</span>) {
                    setTypeface(typeface)<span>;
</span><span>                </span>}
            }
            setCompoundDrawablesWithIntrinsicBounds(drawableLeft<span>, </span>drawableTop<span>, </span>drawableRight<span>, </span>drawableBottom)<span>;
</span><span>            </span>attributeArray.recycle()<span>;
</span><span>        </span>}
    }

    <span>@Override
</span><span>    </span><span>public void </span><span>onClick</span>(View view) {
        Log.<span>d</span>(<span>TAG</span><span>, </span><span>"onClick() called with: view = [" </span>+ view + <span>"]"</span>)<span>;
</span><span>    </span>}
}</pre>
<strong>STEP 5</strong>:- Then create main_activity.xml like below
<pre><span>&lt;com.cretlabs.customtogglebutton.CustomToggleButton
</span><span>    </span><span>android</span><span>:layout_width=</span><span>"wrap_content"
</span><span>    </span><span>android</span><span>:layout_height=</span><span>"wrap_content"
</span><span>    </span><span>android</span><span>:layout_marginBottom=</span><span>"8dp"
</span><span>    </span><span>android</span><span>:layout_marginEnd=</span><span>"8dp"
</span><span>    </span><span>android</span><span>:layout_marginStart=</span><span>"8dp"
</span><span>    </span><span>android</span><span>:drawablePadding=</span><span>"12dp"
</span><span>    </span><span>android</span><span>:layout_marginTop=</span><span>"8dp"
</span><span>    </span><span>android</span><span>:background=</span><span>"@drawable/bg_button_selector"
</span><span>    </span><span>android</span><span>:button=</span><span>"@color/trans"
</span><span>    </span><span>android</span><span>:textOff=</span><span>"on "
</span><span>    </span><span>android</span><span>:textOn=</span><span>"off"
</span><span>    </span><span>android</span><span>:textColor=</span><span>"@color/white"
</span><span>    </span><span>app</span><span>:ct_draw_right=</span><span>"@drawable/ic_down_24dp"
</span><span>    </span><span>app</span><span>:ct_draw_bottom=</span><span>"@drawable/ic_down_24dp"
</span><span>    </span><span>app</span><span>:ct_draw_left=</span><span>"@drawable/ic_down_24dp"
</span><span>    </span><span>app</span><span>:ct_draw_top=</span><span>"@drawable/ic_down_24dp"
</span><span>    </span><span>app</span><span>:ct_fontName=</span><span>"@string/font_steel_works"
</span><span>    </span><span>app</span><span>:layout_constraintBottom_toBottomOf=</span><span>"parent"
</span><span>    </span><span>app</span><span>:layout_constraintEnd_toEndOf=</span><span>"parent"
</span><span>    </span><span>app</span><span>:layout_constraintStart_toStartOf=</span><span>"parent"
</span><span>    </span><span>app</span><span>:layout_constraintTop_toTopOf=</span><span>"parent" </span><span>/&gt;</span></pre>
<strong>STEP 6:-</strong>Add your font file name in strings.xml
<pre><span>&lt;string </span><span>name=</span><span>"steel_work_font"</span><span>&gt;</span>Steelworks Vintage Demo.ttf<span>&lt;/string&gt;</span></pre>
Add font name to Custom text view in activity_main.xml like below

<span>app</span><span>:fontName=</span><span>"@string/steel_work_font"</span>

&nbsp;

&nbsp;

As you wish, you can add multiple fonts to assets and use one by one in your project.

&nbsp;
