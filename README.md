# RESEARCH LOAD IMAGE FROM THE INTERNET 

    * KNOWLEDGE ABOUT ASYNCTASK
    
	Trong AsyncTask<Params, Progress, Result>  có 3 đối số là các Generic Type:

	Params: Là giá trị ((biến) được truyền vào khi gọi thực thi tiến trình và nó sẽ  được truyền vào doInBackground

	Progress: Là  giá trị (biến) dùng để update giao diện diện lúc tiến trình thực thi, biến này sẽ được truyền vào hàm onProgressUpdate.

	Result: Là biến dùng để lưu trữ kết quả trả về sau khi tiến trình thực hiện xong.

	Những đối số nào không sử dụng trong quá trình thực thi tiến trình thì ta thay bằng Void.

	Thông thường trong 1 AsyncTask sẽ chứa 4 hàm, đó là :

	onPreExecute() : Tự động được gọi đầu tiên khi tiến trình được kích hoạt.

	doInBackground(): Được thực thi trong quá trình tiến trình chạy nền, thông qua hàm này để ta gọi hàm onProgressUpdate để cập nhật giao diện (gọi lệnh publishProgress). Ta không thể cập nhật giao diện trong hàm doInBackground().

	onProgressUpdate (): Dùng để cập nhật giao diện lúc runtime

	onPostExecute(): Sau khi tiến trình kết thúc thì hàm này sẽ tự động sảy ra. Ta có thể lấy được kết quả trả về sau khi thực hiện tiến trình kết thúc ở đây.

	Trong 4 hàm trên thì hàm doInBackground() bắt buộc phải tồn tại, còn các hàm khác có thể khuyết, nhưng theo Tui các bạn nên sử dụng đầy đủ 4 hàm đã nêu.

	Đối với AsyncTask thì ta cần tạo một lớp kế thừa từ AsyncTask, sau đó từ MainActivity ta gọi hàm execute() của tiến trình này là OK.

    * WE WILL PRACTISE WITH PROGRESSBAR

    + Create a class MyAsyncTask.java and extends AsyncTask. And Override four method 

	public class MyAsyncTask extends AsyncTask<String,Void,Bitmap> {
	    @Override
	    protected void onPreExecute() {
		super.onPreExecute();
	    }

	    @Override
	    protected void onPostExecute(Bitmap bitmap) {
		super.onPostExecute(bitmap);
	    }

	    @Override
	    protected Bitmap doInBackground(String... strings) {
		return null;
	    }

	    @Override
	    protected void onProgressUpdate(Void... values) {
		super.onProgressUpdate(values);
	    }
	}

    => You see it look like template to using AsyncTask

    + NO result return OK

<p align="center">
  <img src="https://github.com/danisluis6/Technical-Android-AsyncTask/blob/version2/LevelB/1.png">
</p>
