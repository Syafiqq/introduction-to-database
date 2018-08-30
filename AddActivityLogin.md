# Langkah 6 BuatActivity Login

Setelah pembuatan activity login selesai. Ubah fungsi `gotoLogin` pada  `SplashScreenActivity` untuk dapat berpindah dari Acitivity `Splash Screen` ke Activity `Login`

Berikut kode program fungsi `gotoLogin` pada `SplashScreenActivity`
```
private void gotoLogin(View v)
{
    super.startActivity(new Intent(this, LoginActivity.class));
}
```