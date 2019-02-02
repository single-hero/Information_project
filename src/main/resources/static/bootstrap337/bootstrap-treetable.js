/**
 * bootstrapTreeTable
 *
 * @author swifly
 */
(function($) {
    "use strict";

    $.fn.bootstrapTreeTable = function(options, param) {
        var allData = null;//���ڴ�Ÿ�ʽ���������
        // ����ǵ��÷���
        if (typeof options == 'string') {
            return $.fn.bootstrapTreeTable.methods[options](this, param);
        }
        // ����ǳ�ʼ�����
        options = $.extend({}, $.fn.bootstrapTreeTable.defaults, options || {});
        // �Ƿ���radio��checkbox
        var hasSelectItem = false;
        var target = $(this);
        // ������װһ��div����ʽ�õ�bootstrap-table��
        var _main_div = $("<div class='bootstrap-tree-table'></div>");
        target.before(_main_div);
        _main_div.append(target);
        target.addClass("table table-hover treetable-table");
        if (options.striped) {
            target.addClass('table-striped');
        }
        if (options.bordered) {
            target.addClass('table-bordered');
        }
        // ������������װһ��div����ʽ�õ�bootstrap-table��
        if(options.toolbar){
            var _tool_div = $("<div class='treetable-bars pull-left'></div>");
            _tool_div.append($(options.toolbar));
            _main_div.before(_tool_div);
        }
        // ��ʽ�����ݣ��Ż�����
        target.formatData=function(data){
            var _root = options.rootCodeValue?options.rootCodeValue:null
            $.each(data, function(index, item) {
                // ���һ��Ĭ�����ԣ������жϵ�ǰ�ڵ���û�б���ʾ
                item.isShow = false;
                // ������ݼ��ֳ���Root�ڵ�д��
                // Ĭ�ϵļ����ж�
                var _defaultRootFlag = item[options.parentCode] == '0'
                    || item[options.parentCode] == 0
                    || item[options.parentCode] == null
                    || item[options.parentCode] == '';
                if (!item[options.parentCode] || (_root?(item[options.parentCode] == options.rootCodeValue):_defaultRootFlag)){
                    if(!allData["_root_"]){allData["_root_"]=[];}
                    allData["_root_"].push(item);
                }else{
                    if(!allData["_n_"+item[options.parentCode]]){allData["_n_"+item[options.parentCode]]=[];}
                    allData["_n_"+item[options.parentCode]].push(item);
                }
            });
            data=null;//����
        }
        // �õ����ڵ�
        target.getRootNodes = function() {
            return allData["_root_"];
        };
        // �ݹ��ȡ�ӽڵ㲢�������ӽڵ�
        target.handleNode = function(parentNode, lv, row_id, p_id, tbody) {
            var _ls = allData["_n_"+parentNode[options.code]];
            var tr = target.renderRow(parentNode,_ls?true:false,lv,row_id,p_id);
            tbody.append(tr);
            if(_ls){
                $.each(_ls, function(i, item) {
                    var _row_id = row_id+"_"+i
                    target.handleNode(item, (lv + 1), _row_id,row_id, tbody)
                });
            }
        }; 
        // ������
        target.renderRow = function(item,isP,lv,row_id,p_id){
            // �������ʾ
            item.isShow = true;
            var tr = $('<tr id="'+row_id+'" pid="'+p_id+'"></tr>');
            var _icon = options.expanderCollapsedClass;
            if(options.expandAll){
                tr.css("display","table");
                _icon = options.expanderExpandedClass;
            }else if(lv==1){
                tr.css("display","table");
                _icon=(options.expandFirst)?options.expanderExpandedClass:options.expanderCollapsedClass;
            }else if(lv==2){
                if(options.expandFirst){
                    tr.css("display","table");
                }else{
                    tr.css("display","none");
                }
                _icon=options.expanderCollapsedClass;
            }else{
                tr.css("display","none");
                _icon = options.expanderCollapsedClass;
            }
            $.each(options.columns, function(index, column) {
                // �ж���û��ѡ����
                if(column.field=='selectItem'){
                    hasSelectItem = true;
                    var td = $('<td style="text-align:center;width:36px"></td>');
                    if(column.radio){
                        var _ipt = $('<input name="select_item" type="radio" value="'+item[options.id]+'"></input>');
                        td.append(_ipt);
                    } 
                    if(column.checkbox){
                        var _ipt = $('<input name="select_item" type="checkbox" value="'+item[options.id]+'"></input>');
                        td.append(_ipt);
                    } 
                    tr.append(td);
                }else{
                    var td = $('<td title="'+item[column.field]+'" name="'+column.field+'" style="'+((column.width)?('width:'+column.width):'')+'"></td>');
                    // ����formatter��Ⱦ
                    if (column.formatter) {
                        td.attr('align','center')
                        td.html(column.formatter.call(this, item[column.field], item, index));
                    } else {
                        td.text(item[column.field]);
                    }
                    if(options.expandColumn==index){
                        if(!isP){
                            td.prepend('<span class="treetable-expander"></span>')
                        }else{
                            td.prepend('<span class="treetable-expander '+_icon+'"></span>')
                        }
                        for (var int = 0; int < (lv-1); int++) {
                            td.prepend('<span class="treetable-indent"></span>')
                        }
                    }
                    tr.append(td);
                }
            });
            return tr;
        }
        // ��������ǰ
        target.load = function(parms){
            // ��������ǰ�����
            allData = {};
            // ��������ǰ�����
            target.html("");
            // �����ͷ
            var thr = $('<tr></tr>');
            $.each(options.columns, function(i, item) {
                var th = null;
                // �ж���û��ѡ����
                if(i==0&&item.field=='selectItem'){
                    hasSelectItem = true;
                    th = $('<th style="width:36px"></th>');
                }else{
                    th = $('<th style="'+((item.width)?('width:'+item.width):'')+'"></th>');
                }
                th.text(item.title);
                thr.append(th);
            });
            var thead = $('<thead class="treetable-thead"></thead>');
            thead.append(thr);
            target.append(thead);
            // �������
            var tbody = $('<tbody class="treetable-tbody"></tbody>');
            target.append(tbody);
            // ��Ӽ���loading
            var _loading = '<tr><td colspan="'+options.columns.length+'"><div style="display: block;text-align: center;">����Ŭ���ؼ��������У����Ժ򡭡�</div></td></tr>'
            tbody.html(_loading);
            // Ĭ�ϸ߶�
            if(options.height){
                tbody.css("height",options.height);
            }
            if (options.url) {
                $.ajax({
                    type : options.type,
                    url : options.url,
                    data : parms?parms:options.ajaxParams,
                    dataType : "JSON",
                    success : function(data, textStatus, jqXHR) {
                        target.renderTable(data);
                    },
                    error:function(xhr,textStatus){
                        var _errorMsg = '<tr><td colspan="'+options.columns.length+'"><div style="display: block;text-align: center;">'+xhr.responseText+'</div></td></tr>'
                        tbody.html(_errorMsg);
                    },
                });
            } else {
                target.renderTable(options.data);
            }
        }
        // ���������ݺ���Ⱦ���
        target.renderTable = function(data){

            var tbody = target.find("tbody");
            var thead = target.find("thead");
            // ���������������
            tbody.html("");
            if(!data||data.length<=0){
                var _empty = '<tr><td colspan="'+options.columns.length+'"><div style="display: block;text-align: center;">û���ҵ�ƥ��ļ�¼</div></td></tr>'
                tbody.html(_empty);
                return;
            }
            // ��ʽ������
            target.formatData(data);
            // ��ʼ����
            var rootNode = target.getRootNodes();
            if(rootNode){
                $.each(rootNode, function(i, item) {
                    var _row_id = "row_id_"+i
                    target.handleNode(item, 1, _row_id,"row_root", tbody);
                });
            }
            // �±ߵĲ�����Ҫ��Ϊ�˲�ѯʱ��һЩû�и��ڵ�Ľڵ���ʾ
            $.each(data, function(i, item) {
                if(!item.isShow){
                    var tr = target.renderRow(item,false,1);
                    tbody.append(tr);
                }
            });
            target.append(tbody);
            //��̬���ñ�ͷ���
            thead.css("width", tbody.children(":first").css("width"));
            // �е��ѡ���¼�
            target.find("tbody").find("tr").click(function(){
                if(hasSelectItem){
                    var _ipt = $(this).find("input[name='select_item']");
                    if(_ipt.attr("type")=="radio"){
                        _ipt.prop('checked',true);
                        target.find("tbody").find("tr").removeClass("treetable-selected");
                        $(this).addClass("treetable-selected");
                    }else{
                        if(_ipt.prop('checked')){
                            _ipt.prop('checked',false);
                            $(this).removeClass("treetable-selected");
                        }else{
                            _ipt.prop('checked',true);
                            $(this).addClass("treetable-selected");
                        }
                    }
                }
            });
            // Сͼ�����¼�--չ������
            target.find("tbody").find("tr").find(".treetable-expander").click(function(){
                var _isExpanded = $(this).hasClass(options.expanderExpandedClass);
                var _isCollapsed = $(this).hasClass(options.expanderCollapsedClass);
                if(_isExpanded||_isCollapsed){
                    var tr = $(this).parent().parent();
                    var row_id = tr.attr("id");
                    if(_isExpanded){
                        var _ls = target.find("tbody").find("tr[id^='"+row_id+"_']");//������
                        if(_ls&&_ls.length>0){
                            $.each(_ls, function(index, item) {
                                $(item).css("display","none");
                                var _icon = $(item).children().eq(options.expandColumn).find(".treetable-expander");
                                if(_icon.hasClass(options.expanderExpandedClass)){
                                    _icon.removeClass(options.expanderExpandedClass)
                                    _icon.addClass(options.expanderCollapsedClass)
                                }
                            });
                        }
                        $(this).removeClass(options.expanderExpandedClass)
                        $(this).addClass(options.expanderCollapsedClass)
                    }else{
                        var _ls = target.find("tbody").find("tr[pid='"+row_id+"']");//��һ��
                        if(_ls&&_ls.length>0){
                            $.each(_ls, function(index, item) {
                                $(item).css("display","table");
                            });
                        }
                        $(this).removeClass(options.expanderCollapsedClass)
                        $(this).addClass(options.expanderExpandedClass)
                    }
                }
            });
        }
        // ��������
        target.load();
        return target;
    };

    // ���������װ........
    $.fn.bootstrapTreeTable.methods = {
        // Ϊ�˼���bootstrap-table��д����ͳһ�������飬���ﷵ���˱����ʾ�е�����
        getSelections : function(target, data) {
            // ���б�ѡ�еļ�¼input
            var _ipt = target.find("tbody").find("tr").find("input[name='select_item']:checked");
            var chk_value =[]; 
            // �����radio
            if(_ipt.attr("type")=="radio"){
                var _data = {id:_ipt.val()};
                var _tds = _ipt.parent().parent().find("td");
                _tds.each(function(_i,_item){ 
                    if(_i!=0){
                        _data[$(_item).attr("name")]=$(_item).attr("title");
                    }
                }); 
                chk_value.push(_data); 
            }else{
                _ipt.each(function(_i,_item){ 
                    var _data = {id:$(_item).val()};
                    var _tds = $(_item).parent().parent().find("td");
                    _tds.each(function(_ii,_iitem){ 
                        if(_ii!=0){
                            _data[$(_iitem).attr("name")]=$(_iitem).attr("title");
                        }
                    }); 
                    chk_value.push(_data); 
                }); 
            }
            return chk_value;
        },
        // ˢ�¼�¼
        refresh : function(target, parms) {
            if(parms){
                target.load(parms);
            }else{
                target.load();
            }
        },
    // �������������Ҳ���Խ������Ʒ�װ........
    };

    $.fn.bootstrapTreeTable.defaults = {
        id : 'id',// ѡȡ��¼���ص�ֵ
        code : 'id',// �������ø��ӹ�ϵ
        parentCode : 'parentId',// �������ø��ӹ�ϵ
        rootCodeValue: null,//���ø��ڵ�codeֵ----��ָ�����ڵ㣬Ĭ��Ϊnull,"",0,"0"
        data : null, // ����table�����ݼ���
        type : "GET", // �������ݵ�ajax����
        url : null, // �������ݵ�ajax��url
        ajaxParams : {}, // �������ݵ�ajax��data����
        expandColumn : 0,// ����һ��������ʾչ����ť
        expandAll : false, // �Ƿ�ȫ��չ��
        expandFirst : true, // �Ƿ�Ĭ�ϵ�һ��չ��--expandAllΪfalseʱ��Ч
        striped : false, // �Ƿ���н���ɫ
        bordered : true,               // �Ƿ���ʾ�߿�
        columns : [],
        toolbar: null,//����������
        height: 0,
        expanderExpandedClass : 'glyphicon glyphicon-chevron-down',// չ���İ�ť��ͼ��
        expanderCollapsedClass : 'glyphicon glyphicon-chevron-right'// ����İ�ť��ͼ��

    };
})(jQuery);