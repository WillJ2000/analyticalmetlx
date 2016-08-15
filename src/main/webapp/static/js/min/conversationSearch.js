var Conversations=function(){var b="",m=void 0,q={},k=void 0,n="",d=[],f=[],l={},g=void 0,r=!1;$(function(){var a=function(a){jsGrid.Field.call(this,a)},t=function(a){jsGrid.Field.call(this,a)},e=function(a){jsGrid.Field.call(this,a)};a.prototype=new jsGrid.Field({sorter:function(a,c){return new Date(a)-new Date(c)},itemTemplate:function(a){return(new Date(a)).toLocaleString()},insertTemplate:function(a){return""},editTemplate:function(a){return""},insertValue:function(){return""},editValue:function(){return""}});
$("#onlyMyConversations").click(function(){r=$(this).is(":checked");h()});t.prototype=new jsGrid.Field({sorter:function(a,c){return 0},itemTemplate:function(a,c){return c.author==b?$("<a/>",{href:sprintf("/editConversation?conversationJid=%s",c.jid),text:"Edit"}):""},insertTemplate:function(a){return""},editTemplate:function(a){return""},insertValue:function(){return""},editValue:function(){return""}});e.prototype=new jsGrid.Field({sorter:function(a,c){return 0},itemTemplate:function(a,c){return $("<a/>",
{href:sprintf("/board?conversationJid=%s",c.jid),text:"Join"})},insertTemplate:function(a){return""},editTemplate:function(a){return""},insertValue:function(){return""},editValue:function(){return""}});jsGrid.fields.dateField=a;jsGrid.fields.editConversationField=t;jsGrid.fields.joinConversationField=e;g=$("#conversationsDataGrid");g.jsGrid({width:"100%",height:"auto",inserting:!1,editing:!1,sorting:!0,paging:!0,noDataContent:"No conversations match your query",rowClick:function(a){"jid"in a.item&&
(window.location.href=sprintf("/board?conversationJid=%s&unique=true",a.item.jid))},controller:{loadData:function(a){if("sortField"in a){var c=_.sortBy(d,function(c){return c[a.sortField]});r&&(c=_.filter(c,function(a){return a.author==b}));"sortOrder"in a&&"desc"==a.sortOrder&&(c=_.reverse(c));return c}return d}},pageLoading:!1,fields:[{name:"title",type:"text",title:"Title",readOnly:!0},{name:"creation",type:"dateField",title:"Created"},{name:"author",type:"text",title:"Author",readOnly:!0},{name:"subject",
type:"text",title:"Sharing",readOnly:!0},{name:"edit",type:"editConversationField",title:"Edit",sorting:!1,width:30,css:"gridAction"}]});g.jsGrid("sort",{field:"creation",order:"desc"});$("#activeImportsListing").hide();$("#importConversationInputElementContainer").hide();$("#showImportConversationWorkflow").click(function(){$("#importConversationInputElement").click()});$("#importConversationInputElement").fileupload({dataType:"json",add:function(a,c){$("#importConversationProgress").css("width",
"0%");$("#importConversationProgressBar").show();$("#activeImportsListing").show();c.submit()},progressall:function(a,c){var b=parseInt(c.loaded/c.total*100,10)+"%";$("#importConversationProgressBar").css("width",b)},done:function(a,c){$.each(c.files,function(a,c){$("<p/>").text(c.name).appendTo(document.body)});$("#importConversationProgress").fadeOut()}});m=$("#conversationContainerListing");m.find(".conversationContainer").clone();m.empty();k=$("#activeImportsListing");q=k.find(".importContainer").clone();
k.empty();a=$("#conversationSearchBox");l=$("<input/>",{type:"text",val:n});a.append(l);l.on("keydown",function(a){var c=$(this).val();query=c;13==a.keyCode&&p(c)});$("#createConversationButton").on("click",function(){var a=sprintf("%s at %s",b,(new Date).toString());createConversation(a)});$("#searchButton").on("click",function(){p(query)})});var u=function(a){var b=q.clone();b.find(".importId").text(a.id);b.find(".importName").text(a.name);b.find(".importAuthor").text(a.author);var e=b.find(".importProgressContainer"),
d=b.find(".importResultContainer");"result"in a?"a"in a.result?(d.find(".importError").text(a.a.toString()),d.find(".importSuccess").remove(),e.remove()):"b"in a.result&&(d.find(".importSuccess").attr("href",sprintf("/board?conversationJid=%s",a.result.b.jid)),d.find(".importError").remove(),e.remove()):(e=b.find(".importOverallProgressContainer"),e.find(".importProgressDescriptor").text(a.overallProgress.name),e.find(".importProgressProgressBar").css({width:sprintf("%s%%",a.overallProgress.numerator/
a.overallProgress*100)}),e=b.find(".importStageProgressContainer"),e.find(".importProgressDescriptor").text(a.stageProgress.name),e.find(".importProgressProgressBar").css({width:sprintf("%s%%",a.stageProgress.numerator/a.stageProgress*100)}),d.remove());return b},h=function(){if(void 0!=g){g.jsGrid("loadData");var a=g.jsGrid("getSorting");"field"in a&&g.jsGrid("sort",a)}console.log("reRender:",n,d,f);a=_.map(f,u);k.html(a);a=d;a=sprintf("%s result%s",a.length,1==a.length?"":"s");$("#conversationListing").find(".aggregateContainer").find(".count").text(a)},
p=function(a){n=a;getSearchResult(a)};return{receiveUsername:function(a){b=a},receiveUserGroups:function(a){},receiveConversationDetails:function(a){d=_.map(d,function(b){return b.jid==a.jid?a:b});h()},receiveSearchResults:function(a){d=a;h()},receiveNewConversationDetails:function(a){d.push(a);h()},receiveImportDescription:function(a){console.log("importDesc",a);f=_.filter(f,function(b){return b.id!=a.id});f.push(a);h()},receiveImportDescriptions:function(a){console.log("importDescs",a);f=a;h()},
receiveQuery:function(a){query=a;l.val(a);h()},getConversationListing:function(){return listing},getImportListing:function(){return f},getQuery:function(){return query},search:p,create:function(a){createConversation(a)}}}();function serverResponse(b){console.log("serverResponse:",b)}function receiveUsername(b){Conversations.receiveUsername(b)}function receiveUserGroups(b){Conversations.receiveUserGroups(b)}function receiveConversationDetails(b){Conversations.receiveConversationDetails(b)}
function receiveConversations(b){Conversations.receiveSearchResults(b)}function receiveNewConversationDetails(b){Conversations.receiveNewConversationDetails(b)}function receiveImportDescription(b){Conversations.receiveImportDescription(b)}function receiveImportDescriptions(b){Conversations.receiveImportDescriptions(b)}function receiveQuery(b){Conversations.receiveQuery(b)};
