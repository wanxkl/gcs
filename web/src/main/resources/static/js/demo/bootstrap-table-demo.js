/*!
 * Remark (http://getbootstrapadmin.com/remark)
 * Copyright 2015 amazingsurge
 * Licensed under the Themeforest Standard Licenses
 */
function cellStyle(value, row, index) {
  var classes = ['active', 'success', 'info', 'warning', 'danger'];

  if (index % 2 === 0 && index / 2 < classes.length) {
    return {
      classes: classes[index / 2]
    };
  }
  return {};
}

function rowStyle(row, index) {
  var classes = ['active', 'success', 'info', 'warning', 'danger'];

  if (index % 2 === 0 && index / 2 < classes.length) {
    return {
      classes: classes[index / 2]
    };
  }
  return {};
}

function scoreSorter(a, b) {
  if (a > b) return 1;
  if (a < b) return -1;
  return 0;
}

function nameFormatter(value) {
  return value + '<i class="icon wb-book" aria-hidden="true"></i> ';
}

function starsFormatter(value) {
  return '<i class="icon wb-star" aria-hidden="true"></i> ' + value;
}

function queryParams() {
  return {
    type: 'owner',
    sort: 'updated',
    direction: 'desc',
    per_page: 100,
    page: 1
  };
}

function buildTable($el, cells, rows) {
  var i, j, row,
    columns = [],
    data = [];

  for (i = 0; i < cells; i++) {
    columns.push({
      field: '字段' + i,
      title: '单元' + i
    });
  }
  for (i = 0; i < rows; i++) {
    row = {};
    for (j = 0; j < cells; j++) {
      row['字段' + j] = 'Row-' + i + '-' + j;
    }
    data.push(row);
  }
  $el.bootstrapTable('destroy').bootstrapTable({
    columns: columns,
    data: data,
    iconSize: 'outline',
    icons: {
      columns: 'glyphicon-list'
    }
  });
}

(function(document, window, $) {
  'use strict';

  // Example Bootstrap Table From Data
  // ---------------------------------


  // Example Bootstrap Table Columns
  // -------------------------------
  (function() {
    $('#exampleTableColumns').bootstrapTable({
      url: "http://localhost:8080/findTasks",
      height: "400",
      iconSize: 'outline',
      showColumns: true,
      icons: {
        refresh: 'glyphicon-repeat',
        toggle: 'glyphicon-list-alt',
        columns: 'glyphicon-list'
      }
    });
  })();


  // Example Bootstrap Table Large Columns
  // -------------------------------------
  buildTable($('#exampleTableLargeColumns'), 50, 50);


  // Example Bootstrap Table Toolbar
  // -------------------------------



  // Example Bootstrap Table Events
  // ------------------------------
  (function() {
    $('#exampleTableEvents').bootstrapTable({
      url: "http://localhost:8080/findTasks",
//      url: "js/demo/bootstrap_table_test.json",
      search: true,
      pagination: true,
      showRefresh: true,
      showToggle: true,
      showColumns: true,
      iconSize: 'outline',
      toolbar: '#exampleTableEventsToolbar',
      icons: {
        refresh: 'glyphicon-repeat',
        toggle: 'glyphicon-list-alt',
        columns: 'glyphicon-list'
      }
    });

    var $result = $('#examplebtTableEventsResult');
    var  taskDeleteId= '';
    var ids = new Array();
    var href = "/updateTask?id="
    $('#exampleTableEvents').on('all.bs.table', function(e, name, args) {
        //console.log('Event......自定义:',name, ', data:', args);
      })
     .on('check.bs.table', function(e, row) {
                console.log(row.id)
               // href+row.id;
           })
      .on('uncheck.bs.table', function(e, row) {
                console.log(row)
           })
        .on('check-all.bs.table', function(e) {
                console.log(e)
           })
           .on('uncheck-all.bs.table', function(e) {
                console.log(e)
           })
    //$("#updateTask").attr("href","");
      /*.on('sort.bs.table', function(e, name, order) {
        $result.text('Event: sort.bs.table');
      })

      .on('load-success.bs.table', function(e, data) {
        $result.text('Event: load-success.bs.table');
      })
      .on('load-error.bs.table', function(e, status) {
        $result.text('Event: load-error.bs.table');
      })
      .on('column-switch.bs.table', function(e, field, checked) {
        $result.text('Event: column-switch.bs.table');
      })
      .on('page-change.bs.table', function(e, size, number) {
        $result.text('Event: page-change.bs.table');
      })
      .on('search.bs.table', function(e, text) {
        $result.text('Event: search.bs.table');
      });*/
  })();
})(document, window, jQuery);
