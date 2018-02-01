# KotlinFileInOut

## 概要
KotlinでAndroid内のファイルを読み書きするサンプルです。
初Kotlinなのでコードが酷いです。あしからず。

## 説明

### saveFile
FileOutputStreamを用いて、EditTextに入力された文字をtestfile.txtに書き込みます。

### readFile
FileInputStreamを用いてtestfile.txtの内容を読み込み、TextViewに表示します。

### Kotlin Android Extensions
Kotlinでのみ使えるAndroid用のの拡張機能らしいですが、とても便利です。
従来はactivity\_main内に定義されたViewコンテンツを扱うにはMainActivity.java内で新たに変数を用意し、findViewByIdを用いて参照を定義、その後リスナーの設定などをしていましたがこの拡張機能を用いるとactivity\_main内で指定したidをそのまま変数として用いることが出来ます。
無駄な変数も減り、コード記述量も大幅に減るので助かります。

参考：
- [KotlinAndroidExtension](https://qiita.com/sekitaka_1214/items/7d1156e56c2a670ea649)
- [FileInOutWithJava](https://akira-watson.com/android/fileoutputstream.html)

## About
This is silly example of how to read/write local file on Android.
Excuse : It's first time I write programs with Kotlin, quite terrible code has produced.

## Description

### saveFile
save string written in EditText to "testfile.txt", using FileOutputStream.

### readFile
read content of "testfile.txt" using FileInputStream and show it.

### Kotlin Android Extensions
What awesome extensions!
Thanks to this, I could set listeners and others to components declared in "activity\_main.xml" without using "findViewById" function.

refs : 
- [KotlinAndroidExtension](https://qiita.com/sekitaka_1214/items/7d1156e56c2a670ea649)
- [FileInOutWithJava](https://akira-watson.com/android/fileoutputstream.html)

