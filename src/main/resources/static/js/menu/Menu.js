$(function () {
    if(!!$("#listId").val()){
        $('#tableTree').bootstrapTreeTable({
            toolbar:null,      //顶部工具条
            id : "id",                      // 选取记录返回的值
            code : "id",                    // 用于设置父子关系
            parentCode : "parentId",        // 用于设置父子关系
            expandColumn : 0,               // 在哪一列上面显示展开按钮
            expandAll : false,				// 是否全部展开
            expandFirst : false,
            expanderExpandedClass : 'glyphicon glyphicon-chevron-down',// 展开的按钮的图标
            expanderCollapsedClass : 'glyphicon glyphicon-chevron-right',// 缩起的按钮的图标
            columns: [{
                title: '菜单名称',
                field: 'menuName',
                width: '10%',
            },{
                title: '状态',
                field: 'state',
                width: '5%',
                formatter:function(value,row,index){
                    if(row.state==0){
                        return '<span class="label label-success">正常</span>';
                    }
                    return '<span class="label label-default">冻结</span>';
                }
            },{
                title: '排序',
                field: 'rank',
                width: '5%',
                formatter:function(value,row,index){
                    return '<input type="number" min="1" style="width: 60px; height: 30px;" onblur="editRank(this.value,'+row.id+')" value='+row.rank+'>';
                }
            },{
                title: '操作',
                width: '10%'
            }],
            data:JSON.parse($("#listId").val()).data
        });
    }
    else{
        $('#tableTree').val("没有数据..")
    }
});

//排序
function editRank(rank,id){
    successSpop("修改成功");
    setTimeout("window.location.reload()",2500)
    var url = "<%=basePath%>Mess/editRank?id="+id+"&rank="+rank;
}