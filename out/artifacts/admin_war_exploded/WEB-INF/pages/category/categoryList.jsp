<%--
  Created by IntelliJ IDEA.
  User: decent
  Date: 2018/3/11
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common-head.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>分类列表</title>
    <style>
        .form-horizontal .control-label {
            width: 95px;
        }

        .form-horizontal .controls {
            margin-left: 110px;
        }

        #myModal3 {
            left: 40%;
        }
    </style>
</head>
<body>
<div class="container-fluid animated fadeInRight">
    <div class="row-fluid">
        <div class="span12">
            <div class="widget-box">
                <div class="widget-title" style="height: auto;display: inline">
                    <form action="#" method="get" class="form-inline" id="searchForm">
                        <div class="control-group">

                            <label class="control-label">产品名称:</label>
                            <div class="controls">
                                <input type="text" id="userNames" class="span11"
                                       placeholder="请输入产品名称"/>
                            </div>
                            <label class="control-label">价格:</label>
                            <div class="controls">
                                <input type="text" id="price" class="span11"
                                       placeholder="请输入产品价格"/>
                            </div>

                            <label class="control-label">状态:</label>
                            <div class="controls">
                                <select name="status" id="status">
                                    <option value="">全部</option>
                                    <option value="ON">上架</option>
                                    <option value="OFF">下架</option>
                                </select>
                            </div>
                            <label class="control-label">类型:</label>
                            <div class="controls">
                                <select name="type" id="type">
                                    <option value="">全部</option>
                                    <option value="FLOW">流量</option>
                                    <option value="BILL">话费</option>
                                    <option value="TENCENT">腾讯产品</option>
                                </select>
                            </div>
                            <label class="control-label">范围:</label>
                            <div class="controls">
                                <select name="area" id="area">
                                    <option value="">全部</option>
                                    <option value="DOMESTIC">全国</option>
                                    <option value="PROVINCIAL">省内</option>
                                </select>
                            </div>

                            <div class="controls" style="margin-left: 20px;">
                                <button class="btn btn-primary" type="button" id="searchData"><i
                                        class="fa fa-search"></i>搜索
                                </button>
                                <button class="btn btn-success" type="button" id="add"><i class="fa fa-plus"></i>创建
                                </button>
                                <div class="btn-group">
                                    <button class="btn" type="button" data-toggle="dropdown" >修改状态</button>
                                    <button data-toggle="dropdown" class="btn dropdown-toggle"><span class="caret"></span></button>
                                    <ul class="dropdown-menu" id="toUpdateStatus">
                                        <c:forEach items="${ProductStatus}" var="status" varStatus="s">
                                            <li><a href="javascript:void(0)" data-value="${status.key}">${status.value}</a></li>
                                        </c:forEach>
                                    </ul>
                                </div>


                            </div>

                        </div>
                    </form>
                </div>
                <div class="widget-content nopadding">
                    <table class="table" data-striped="true"
                           id="data-table">
                    </table>
                </div>
            </div>
        </div>
    </div>


</div>


<div id="myModal3" data-backdrop="static" class="modal hide animated fadeInRight" style="width: 800px;">
    <div class="modal-header">
        <button data-dismiss="modal" class="close" type="button">×</button>
        <h3>创建产品</h3>
    </div>
    <div class="modal-body" style="padding-bottom: 30px;">
        <form action="#" method="get" class="form-horizontal" id="addForm">

            <div class="row-fluid">
                <div class="span6">

                    <div class="control-group">
                        <label class="control-label">产品名称<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="name"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">价格<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="price"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">开始时间<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <div class="input-append date datepicker">
                                <input class="span11" id="addStartTime" name="startTime">
                                <span class="add-on"><i class="fa fa-calendar"></i></span></div>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">流量有效期<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select name="validity">
                                <option value="0">当月有效</option>
                                <option value="1">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">容量<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="capacity"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">生效类型<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select  name="effectTime">
                                <c:forEach items="${EffectTime}" var="type" varStatus="s">
                                    <option value="${type.key}">${type.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                </div>
                <div class="span6">
                    <div class="control-group">
                        <label class="control-label">类型<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select  name="type">
                                <c:forEach items="${ProductType}" var="status" varStatus="s">
                                    <option value="${status.key}">${status.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">范围<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select  name="area">
                                <c:forEach items="${ProductArea}" var="range" varStatus="s">
                                    <option value="${range.key}">${range.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">结束时间<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <div class="input-append date datepicker">
                                <input class="span11" id="addEndTime" name="endTime">
                                <span class="add-on"><i class="fa fa-calendar"></i></span></div>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">单次允许购买最大数量<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="singleAllowQuantity"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">单位<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="unit"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">备注:</label>
                        <div class="controls">
                            <textarea name="comment"></textarea>
                        </div>
                    </div>

                </div>

            </div>

        </form>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary" href="javascript:void(0)" id="toAdd">确定</a>
        <a data-dismiss="modal" class="btn" href="javascript:void(0)">取消</a></div>
</div>


<div id="myModal4" data-backdrop="static" class="modal hide animated fadeInRight" style="width: 800px;">
    <div class="modal-header">
        <button data-dismiss="modal" class="close" type="button">×</button>
        <h3>修改产品</h3>
    </div>
    <div class="modal-body" style="padding-bottom: 30px;">
        <form action="#" method="get" class="form-horizontal" id="editForm">
            <input name="id" type="hidden"/>
            <div class="row-fluid">
                <div class="span6">

                    <div class="control-group">
                        <label class="control-label">产品名称<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="name"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">价格<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="price"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">开始时间<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <div class="input-append date datepicker">
                                <input class="span11" id="editStartTime" name="startTime">
                                <span class="add-on"><i class="fa fa-calendar"></i></span></div>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">流量有效期<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select name="validity">
                                <option value="0">当月有效</option>
                                <option value="1">其他</option>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">容量<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="capacity"/>
                        </div>
                    </div>

                    <div class="control-group">
                        <label class="control-label">生效类型<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select  name="effectTime">
                                <c:forEach items="${EffectTime}" var="type" varStatus="s">
                                    <option value="${type.key}">${type.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="span6">
                    <div class="control-group">
                        <label class="control-label">类型<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select  name="type">
                                <c:forEach items="${ProductType}" var="status" varStatus="s">
                                    <option value="${status.key}">${status.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">范围<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <select  name="area">
                                <c:forEach items="${ProductArea}" var="range" varStatus="s">
                                    <option value="${range.key}">${range.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">结束时间<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <div class="input-append date datepicker">
                                <input class="span11" id="editEndTime" name="endTime">
                                <span class="add-on"><i class="fa fa-calendar"></i></span></div>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">单次允许购买最大数量<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="singleAllowQuantity"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">单位<span style="color: red">*</span>:</label>
                        <div class="controls">
                            <input type="text" name="unit"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">备注:</label>
                        <div class="controls">
                            <textarea name="comment"></textarea>
                        </div>
                    </div>

                </div>

            </div>

        </form>
    </div>
    <div class="modal-footer">
        <a class="btn btn-primary" href="javascript:void(0)" id="toEdit">确定</a>
        <a data-dismiss="modal" class="btn" href="javascript:void(0)">取消</a></div>
</div>


<jsp:include page="../common-footer.jsp"></jsp:include>
<script>
    $(document).ready(function () {
        $('#data-table').bootstrapTable({
            url: ctxPath + '/product/list',
            height: $(window).height() - 110,
            pageSize: 30,
            pagination: true,
            pageList: [30, 50, 100],
            clickToSelect: true,
            singleSelect: false,
            queryParams: queryParams,
            uniqueId: 'id',
            queryParamsType: '',
            sidePagination: 'server',
            columns: [
                {
                    width: '3px',
                    align: 'center',
                    formatter: function (v, row, index) {
                        return index + 1
                    }
                }, {
                    checkbox: true,
                    width: '13px',
                },
                {
                    width: '40px',
                    align: 'center',
                    field: 'name',
                    title: '产品名称',

                },
                {
                    width: '40px',
                    align: 'center',
                    field: 'price',
                    title: '价格',


                }, {
                    width: '40px',
                    align: 'center',
                    field: 'status',
                    title: '状态',
                    sortable: true,
                    formatter: function (v, row, index) {
                        return productStatus[v];
                    }


                }, {
                    width: '40px',
                    align: 'center',
                    field: 'type',
                    title: '类型',
                    sortable: true,
                    formatter: function (v, row, index) {
                        return productType[v];
                    }


                }, {
                    width: '40px',
                    align: 'center',
                    field: 'area',
                    title: '范围',
                    sortable: true,
                    formatter: function (v, row, index) {
                        return productArea[v];
                    }
                }, {
                    width: '40px',
                    align: 'center',
                    field: 'effectTime',
                    title: '生效类型',
                    sortable: true,
                    formatter: function (v, row, index) {
                        return effectTime[v];
                    }

                }, {
                    width: '40px',
                    align: 'center',
                    field: 'validity',
                    title: '流量有效期',
                    formatter: function (v, row, index) {
                        return flowValidity[v];
                    }
                }, {
                    width: '40px',
                    align: 'center',
                    field: 'capacity',
                    title: '容量'

                }, {
                    width: '40px',
                    align: 'center',
                    field: 'unit',
                    title: '单位'

                }, {
                    width: '40px',
                    align: 'center',
                    field: 'startTime',
                    title: '有效期开始时间',
                    formatter: function (v, row, index) {
                        return format(v);
                    }

                }, {
                    width: '40px',
                    align: 'center',
                    field: 'endTime',
                    title: '有效期结束时间',
                    formatter: function (v, row, index) {
                        return format(v);
                    }

                }, {
                    width: '40px',
                    align: 'center',
                    field: 'singleAllowQuantity',
                    title: '单次允许购买最大数量'

                }, {
                    width: '40px',
                    align: 'center',
                    field: 'comment',
                    title: '备注'

                }, {
                    align: 'center',
                    width: '80px',
                    field: 'comment',
                    title: '操作',
                    formatter: function (v, row, index) {
                        return '<a href="javascript:void(0)" onclick=toUpdate("' + row.id + '")>修改</a>&nbsp;' +
                            '<a href="javascript:void(0)" onclick=toDelete("' + row.id + '")>删除</a>';
                    }
                }

            ],
        });


        $("#addForm").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2,
                    maxlength: 10

                },
                comment: {
                    minlength: 2,
                    maxlength: 100
                },
                startTime: {
                    required: true
                },
                endTime: {
                    required: true
                },
                price: {
                    required: true,
                    number:true
                },
                validity: {
                    required: true
                },
                capacity: {
                    required: true,
                    number:true
                },
                effectTime: {
                    required: true
                },
                type: {
                    required: true
                },
                area: {
                    required: true
                },
                singleAllowQuantity: {
                    required: true
                },
                unit: {
                    required: true
                }
            },
            errorClass: "help-inline",
            errorElement: "span",
            highlight: function (element, errorClass, validClass) {
                $(element).parents('.control-group').addClass('error');
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).parents('.control-group').removeClass('error');
                // $(element).parents('.control-group').addClass('success');
            }
        });
        $("#editForm").validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2,
                    maxlength: 10

                },
                comment: {
                    minlength: 2,
                    maxlength: 100
                },
                startTime: {
                    required: true
                },
                endTime: {
                    required: true
                },
                price: {
                    required: true,
                    number:true
                },
                validity: {
                    required: true
                },
                capacity: {
                    required: true,
                    number:true
                },
                effectTime: {
                    required: true
                },
                type: {
                    required: true
                },
                area: {
                    required: true
                },
                singleAllowQuantity: {
                    required: true
                },
                unit: {
                    required: true
                }
            },
            errorClass: "help-inline",
            errorElement: "span",
            highlight: function (element, errorClass, validClass) {
                $(element).parents('.control-group').addClass('error');
            },
            unhighlight: function (element, errorClass, validClass) {
                $(element).parents('.control-group').removeClass('error');
                // $(element).parents('.control-group').addClass('success');
            }
        });
        $("#addStartTime").flatpickr({
            enableTime: true,
            defaultDate: getDefaultStartTime(),
            enableSeconds: true
        });
        $("#addEndTime").flatpickr({
            enableTime: true,
            defaultDate: getDefaultEndTime(),
            enableSeconds: true
        });
        $("#searchData").click(function () {
            $("#data-table").bootstrapTable("refresh")
        })
        $("#add").click(function () {

            $("#addForm input[type='text']").val("");
            $("#addForm input[type='number']").val(1);
            $("#myModal3").modal("show");
            $("#addForm select[name='type']").trigger("change");
        });

        $("#toAdd").click(function () {


//            console.log($("#addForm").serialize());
            var v = $("#addForm").valid();
            if (!v) {
                return;
            }
            $.ajax({
                    type: "post",
                    url: "<%=basePath%>/product/add",
                    data: $("#addForm").serialize(),
                    dataType: "json",
                    success: function (data) {
                        if (data.success) {
                            $.message('新增成功');
                            $("#data-table").bootstrapTable("refresh");
                            $("#myModal3").modal("hide");
                        } else {
                            $.message({
                                message: '新增失败',
                                type: 'error'
                            });
                        }
                    },
                    beforeSend: function () {
                    }
                }
            );
        })


        $("#toEdit").click(function () {

//            var v = $("#editForm").valid();
//            if (!v) {
//                return;
//            }
            $.ajax({
                    type: "GET",
                    url: "<%=basePath%>/product/update",
                    data: $("#editForm").serialize(),
                    dataType: "json",
                    success: function (data) {
                        if (data.success) {
                            $.message('修改成功');
                            $("#data-table").bootstrapTable("refresh")
                            $("#myModal4").modal("hide");
                        } else {
                            $.message({
                                message: '修改失败',
                                type: 'error'
                            });
                        }
                    },
                    beforeSend: function () {
                    }
                }
            );

        })

        $("#toUpdateStatus li a").click(function () {
            var $_obj=$(this);
            var status=$_obj.attr("data-value");
            var text=$_obj.text();
            var rows=$("#data-table").bootstrapTable("getSelections");
            if(rows==null||rows.length==0){
                $.message({
                    message:'请选择要操作的数据！',
                    type:'warning'
                });
                return;
            }

            new $.flavr({
                content: '确定修改产品的状态为['+text+']?',
                dialog: 'confirm', onConfirm: function () {
                    $.ajax({
                            type: "GET",
                            url: "<%=basePath%>/product/updateStatus",
                            data: {
                                id:""+rows[0].id,
                                status:status
                            },
                            dataType: "json",
                            success: function (data) {
                                if(data.success){

                                    $.message('操作成功');
                                    $("#data-table").bootstrapTable("refresh")
                                }else {
                                    $.message({
                                        message:'操作失败',
                                        type:'error'
                                    });
                                }
                            },
                            beforeSend: function () {
                            }
                        }
                    );

                }, onCancel: function () {

                }
            });


        })


    })


    function queryParams(params) {
        return {
            pageSize: params.pageSize,
            pageNumber: params.pageNumber,
            name: $("#userNames").val(),
            price: $("#price").val(),
            status: $("#status").val(),
            type: $("#type").val(),
            area: $("#area").val(),
//            status:$("#status").val(),
//            queryStartTime:$("#queryStartTime").val(),
//            queryEndTime:$("#queryEndTime").val()
        };
    }

    function toDelete(id) {

        new $.flavr({
            content: '确定删除改数据吗?',
            dialog: 'confirm', onConfirm: function () {
                $.ajax({
                        type: "GET",
                        url: "<%=basePath%>/product/delete/" + id,
                        data: $("#editForm").serialize(),
                        dataType: "json",
                        success: function (data) {
                            if (data.success) {
                                $.message('删除成功');
                                $("#data-table").bootstrapTable("refresh")
                            } else {
                                $.message({
                                    message: '删除失败',
                                    type: 'error'
                                });
                            }
                        },
                        beforeSend: function () {
                        }
                    }
                );

            }, onCancel: function () {

            }
        });

    }
    function toUpdate(id) {
        var row = $("#data-table").bootstrapTable("getRowByUniqueId", id);

        row.startTime = format(row.startTime);
        row.endTime = format(row.endTime);
        $("#myModal4").modal("show");
        $("#editForm").form("load", row);
        $("#editForm .activityLogo").attr("src", ctxPath + row.logoUrl);
        $("#editForm select[name='type']").trigger("change");
    }


</script>
</body>
</html>
