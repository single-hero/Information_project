/*since:2019.02.01 chenwenwei*/
var nthTabs;
$(function () {
    //初始化
    nthTabs = $("#indexTabId").nthTabs();
    var content ='<h1 style="padding: 25px 15px;">公告信息</h1>'
    nthTabs.addTab({
        id:'a',
        title:'公告',
        content:content,
        active:true,        //默认选中状态
        allowClose:false,
    });


    //左导航栏树形结构
    var list = JSON.parse($("#menu").val());
    var  oTemp = document.createDocumentFragment();
    //获取id
    var nav = document.getElementById('nav');
    //遍历
    list.forEach(function (item,i,list) {
        var li = document.createElement('li');  //创建li标签
        var Oa = document.createElement('a');   //创建a标签
        //a标签添加属性
        Oa.innerHTML = item.menuName;
        Oa.id = item.id;
        Oa.href=item.url ||'#subPages'+i;
        //将a标签插入li标签里面
        li.appendChild(Oa);
        oTemp.appendChild(li);

        if(!!item.menuNode && item.menuNode.length > 0) {
            //有下级关系的
            //给a标签增加class样式
            Oa.className='collapsed';
            //给a标签增加自定义属性
            Oa.setAttribute("data-toggle","collapse");
            var creI=document.createElement('i');       //创建i标签
            creI.className='icon-submenu lnr lnr-chevron-left';   //给i标签添加class样式
            Oa.appendChild(creI);

            var creDiv = document.createElement('div');   //子菜单div标签
            creDiv.id="subPages" + i; //子菜单divid
            creDiv.className='collapse';//子菜单divclass
            var creul = document.createElement('ul');   //子菜单ul标签
            creul.className= 'nav';
            item.menuNode.forEach(function (item_n,n,list_n) {
                var menuli = document.createElement('li');  //创建li标签
                var menua = document.createElement('a');   //创建a标签
                menua.id=item_n.id;
                menua.href = item_n.url || '';
                menua.innerHTML = item_n.menuName;
                menuli.appendChild(menua);
                creul.appendChild(menuli);
            });
            creDiv.appendChild(creul);
            li.appendChild(creDiv);
        }
    });
    nav.appendChild(oTemp);
});


//点击左边导航栏触发nthTabs,增加tab
$("#nav").click(function (e) {
    e.preventDefault();     //阻止默认事件(禁止href跳转)
    //检查是否有下级关系,有下级关系就不创建tab
    if(e.target.href.indexOf("#")==-1){
        menuAddTab(e.target.id,e.target.text,e.target.href);
    }
});

//增加tab方法
function menuAddTab(id,name,url){
    //创建一个iframe标签
    var content = '<iframe id="'+'myiframe'+id+'" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;" onload="changeFrameHeight(id)"></iframe>';
    //nthTabs.getTabList()获取所有选项卡,查看是否存在此选项卡,存在则选中,不存在则创建并选中
    if(JSON.stringify(nthTabs.getTabList()).indexOf("#myTab"+id)==-1){
        nthTabs.addTab({
            id:"myTab"+id,
            title:name,
            content:content,
        });
    }
    //切换到指定的选项卡
    nthTabs.setActTab("myTab"+id);
}


//iframe自适应高度
function changeFrameHeight(iframeid){
    var ifm= document.getElementById(iframeid);
    ifm.height=document.documentElement.clientHeight-127;       //-127 扣除顶部高度与工具栏高度
}
//屏幕监听,当屏幕分辨率改变则触发
window.onresize=function(){
    changeFrameHeight();
};