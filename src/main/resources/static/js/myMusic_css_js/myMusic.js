/**
 * 1.播放音乐方法默认请求的是: media/music/xxx.mp3
 * 2.<body>中创建一个`<div class="box">
 *                      <audio id="audio"></audio>
 *                  </div>
 *                  `
 * 3.方法中含有拖拽事件鼠标点击边缘border可以拖动
 * 4.注意必须引入css样式
 * 5.如何使用`<script>
 *              myMusic(source)
 *          </script>
 *          `
 * @param source 接收源为,间隔的含后缀的歌曲名字符串
 */
function myMusic(source) {

    var musics = source.split(",");
    var absMusics = musics.map(m=>"media/music/"+ m);

    var box = document.getElementsByClassName("musicbox")[0]; //获取元素
    var x, y; //鼠标相对与div左边，上边的偏移
    var isDrop = false; //移动状态的判断鼠标按下才能移动
    box.onmousedown = function(e) {
        var e = e || window.event; //要用event这个对象来获取鼠标的位置
        x = e.clientX - box.offsetLeft;
        y = e.clientY - box.offsetTop;
        isDrop = true; //设为true表示可以移动
    }

    document.onmousemove = function(e) {
        //是否为可移动状态                　　　　　　　　　　　 　　　　　　　
        if(isDrop) {
            var e = e || window.event;
            var moveX = e.clientX - x; //得到距离左边移动距离                    　　
            var moveY = e.clientY - y; //得到距离上边移动距离
            //可移动最大距离
            var maxX = document.documentElement.clientWidth - box.offsetWidth;
            var maxY = document.documentElement.clientHeight - box.offsetHeight;

            //范围限定方法
            moveX=Math.min(maxX, Math.max(0,moveX));

            moveY=Math.min(maxY, Math.max(0,moveY));
            box.style.left = moveX + "px";
            box.style.top = moveY + "px";
        } else {
            return;
        }

    }

    document.onmouseup = function() {
        isDrop = false; //设置为false不可移动
    }

    //绑定一个点击事件
    window.onload = function(){
        // 初始化对象
        var myAudio = document.getElementById("audio");
        //含路径的歌单
        var arr = absMusics;
        myAudio.preload = true;
        myAudio.controls = true;
        //随机列表开始播放，100首的数组长度是101随机取最小整数故0...100;
        myAudio.src = arr[Math.floor(Math.random()*arr.length)];
        myAudio.addEventListener('ended', playEndedHandler, false);
        myAudio.play();
        //禁止单曲循环，否则无法触发ended播放结束事件
        myAudio.loop = false;
        //歌单结束后函数
        function playEndedHandler(){
            //播放结束从第一个开始播放
            myAudio.src = arr[0];
            myAudio.play();
            //只有一个元素时解除绑定
            !arr.length && myAudio.removeEventListener('ended',playEndedHandler,false);
        }
    }
}