package com.example.enclaveit.levela;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button action;
    private ImageView img;
    private ProgressDialog dialog;
    private List<String> listGirl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        addOnListener();
    }

    private void addOnListener() {
        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call a AsyncTask
                processLoadImage();
            }
        });
    }

    private void processLoadImage() {
        String url = "https://farm7.staticflickr.com/6019/5912491041_7a5bd26144.jpg";
        String url1 = "http://blog.charmdate.com/wp-content/uploads/2014/10/d-1.jpg";
        String url2 = "http://notarin.ir/wp-content/uploads/%D8%B9%DA%A9%D8%B3-%D9%88-%D8%A7%D8%B3%D8%A7%D9%85%DB%8C-%D8%A8%D8%A7%D8%B2%DB%8C%DA%AF%D8%B1%D8%A7%D9%86-%D8%B2%D9%86-%DA%A9%D8%B1%D9%87-%D8%A7%DB%8C-8.jpg";
        String url3 = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEg55RX05mOcUwzMmel1oS5tVC0W7jaXkyquxI3VT2v_XM2lDQ7g";
        String url4 = "https://ae01.alicdn.com/kf/HTB1OM28IXXXXXXuXVXXq6xXFXXXG/Indian-Beauty-Girl-Woman-5D-DIY-Diamond-Painting-Cross-Stitch-Of-Diamonds-Embroidery-Mosaic-30-40.jpg";
        listGirl.add(url);
        listGirl.add(url1);
        listGirl.add(url2);
        listGirl.add(url3);
        listGirl.add(url4);
        ImageAsyncTask imageAsyncTask = new ImageAsyncTask();
        imageAsyncTask.execute(listGirl.get(new Random().nextInt(listGirl.size())));
    }

    private void initComponents() {
        action = (Button)this.findViewById(R.id.action);
        img = (ImageView)this.findViewById(R.id.img);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Announcement");
        dialog.setMessage("Waiting for loading image from internet...");
        // Cancle Event OnTouch => Don't turn off box dialog.
        dialog.setCanceledOnTouchOutside(false);

        listGirl = new ArrayList<>();
    }

    /**
     * Trong AsyncTask<Params, Progress, Result>  có 3 đối số là các Generic Type:

     * Params: Là giá trị ((biến) được truyền vào khi gọi thực thi tiến trình và nó sẽ  được truyền vào doInBackground

     * Progress: Là  giá trị (biến) dùng để update giao diện diện lúc tiến trình thực thi, biến này sẽ được truyền vào hàm onProgressUpdate.

     * Result: Là biến dùng để lưu trữ kết quả trả về sau khi tiến trình thực hiện xong.

     * Những đối số nào không sử dụng trong quá trình thực thi tiến trình thì ta thay bằng Void.

     * Thông thường trong 1 AsyncTask sẽ chứa 4 hàm, đó là :

     * onPreExecute() : Tự động được gọi đầu tiên khi tiến trình được kích hoạt.

     * doInBackground(): Được thực thi trong quá trình tiến trình chạy nền, thông qua hàm này để ta gọi hàm onProgressUpdate để cập nhật giao diện (gọi lệnh publishProgress). Ta không thể cập nhật giao diện trong hàm doInBackground().

     * onProgressUpdate (): Dùng để cập nhật giao diện lúc runtime

     * onPostExecute(): Sau khi tiến trình kết thúc thì hàm này sẽ tự động sảy ra. Ta có thể lấy được kết quả trả về sau khi thực hiện tiến trình kết thúc ở đây.

     * Trong 4 hàm trên thì hàm doInBackground() bắt buộc phải tồn tại, còn các hàm khác có thể khuyết, nhưng theo Tui các bạn nên sử dụng đầy đủ 4 hàm đã nêu.

     * Đối với AsyncTask thì ta cần tạo một lớp kế thừa từ AsyncTask, sau đó từ MainActivity ta gọi hàm execute() của tiến trình này là OK.
     */
    class ImageAsyncTask extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            img.setImageBitmap(bitmap);
            dialog.dismiss();
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            /**
             * @author: Excecute get images from the internet.
             * Writting method or function to get image(SEARCH STAKEOVERFLOW)
             */
            try{
                String link = strings[0];
                Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL(link).getContent());
                return bitmap;
            }catch (Exception ex){
                Log.d("Error",ex.getMessage().toString());
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
