var Plugins = (function(){
    return {
        "Face to face":(function(){
            var container = $("<div />");
            return {
                style:".publishedStream {background:green;} .subscribedStream {background:red;}"+
                    " .publisherVideoElem, .subscriberVideoElem {display:flex;}"+
                    " .videoConfStartButton, .videoConfSubscribeButton {background:white;}"+
                    " .videoConfSessionContainer, .videoConfStartButtonContainer, .videoConfContainer{display:flex;}"+
                    " .broadcastContainer{display:none;}",
                load:function(bus,params){
                    container.append('<span id="videoConfSessionsContainer">'+
                                     '<div class="videoConfSessionContainer">'+
                                     '<span class="videoConfStartButtonContainer">'+
                                     '<button class="floatingToolbar btn-menu fa fa-video-camera btn-icon videoConfStartButton">'+
                                     '<div class="icon-txt">Send video</div>'+
                                     '</button>'+
                                     '</span>'+
                                     '<span class="broadcastContainer">'+
                                     '<a class="floatingToolbar btn-menu fa fa-television btn-icon broadcastLink">'+
                                     '<div class="icon-txt">Watch class</div>'+
                                     '</a>'+
                                     '</span>'+
                                     '<div class="videoSubscriptionsContainer"></div>'+
                                     '<div class="videoConfContainer">'+
                                     '<span class="videoContainer">'+
                                     '<button class="floatingToolbar btn-menu fa fa-television btn-icon videoConfSubscribeButton">'+
                                     '<div class="icon-txt">Receive</div>'+
                                     '</button>'+
                                     '</span>'+
                                     '</div>'+
                                     '</div>'+
                                     '</span>');
                    return container;
                },
                initialize:TokBox.initialize
            }
        })(),
        "Groups":(function(){
            var container = $("<div />").css({display:"flex"});
            var button = function(icon,content,behaviour){
                var b = $("<button />",{
                    class:sprintf("%s btn-icon fa",icon),
                    click:behaviour
                });
                $("<div />",{
                    class:"icon-txt",
                    text:content
                }).appendTo(b);
                return b;
            };
            return {
                style:".groupsPluginMember{margin-left:0.5em;}"+
                    " .groupsPluginGroupContainer{display:table-cell;display:flex;}"+
                    " .groupsPluginGroupContainer .icon-txt{color:white;}"+
                    " .groupsPluginGroup{display:inline-block;text-align:center;vertical-align:top;}"+
                    " .groupsPluginControls button, .groupsPluginControls .icon-txt{padding:0;color:white;margin-top:0;}"+
                    " .groupsPluginControls button{display:block;}",
                load:function(bus,params) {
                    var render = function(){
                        try{
                            container.empty();
                            var slide = Conversations.getCurrentSlide();
                            if(slide){
                                var groupSet = slide.groupSet;
                                if(groupSet){
                                    _.each(groupSet.groups,function(group){
                                        var gc = $("<div />",{
                                            class:"groupsPluginGroupContainer"
                                        }).appendTo(container);

                                        var controls = $("<div />",{
                                            class:"groupsPluginControls groupsPluginGroup"
                                        }).appendTo(gc);
                                        button("fa-share-square isolate","Submit screen",function(){}).appendTo(controls);
                                        $("<input />",{
                                            type:"range",
                                            orient:"vertical",
                                            min:0,
                                            max:100,
                                            value:50
                                        }).css({
                                            "writing-mode":"bt-lr", /* IE */
                                            width: "1em",
                                            height: "5em",
                                            "webkit-appearance":"slider-vertical"
                                        }).appendTo(controls);

                                        var right = $("<div />").appendTo(gc);
                                        var id = _.uniqueId("l");
                                        var isolate = $("<div />",{
                                            class:"isolateGroup"
                                        }).append($("<input />",{
                                            type:"checkbox",
                                            id:id
                                        })).append($("<label />",{
                                            for:id
                                        }).append($("<span />",{
                                            class:"icon-txt",
                                            text:"Isolate"
                                        }))).appendTo(right);
                                        var members = $("<div />",{
                                            class:"groupsPluginGroup"
                                        }).appendTo(right);
                                        _.each(group.members,function(member){
                                            $("<div />",{
                                                text:member,
                                                class:"groupsPluginMember"
                                            }).appendTo(members);
                                        });
                                    });
                                }
                            }
                        }
                        catch(e){
                            console.log("Groups plugin render e",e);
                        }
                    };
                    bus.afterJoiningSlide["Groups plugin"] = render;
                    bus.conversationDetailsReceived["Groups plugin"] = render;
                    return container;
                },
                initialize:function(){}
            };
        })()
    };
})();
$(function(){
    var pluginBar = $("#pluginBar");
    var styleContainer = $("<style></style>").appendTo($("body"));
    _.each(Plugins,function(plugin,label){
        var container = $("<div />",{
            class:"plugin"
        });
        $("<div />",{
            text:label,
            class:"pluginName"
        }).prependTo(container);
        plugin.load(Progress).appendTo(container);
        styleContainer.append(plugin.style);
        container.appendTo(pluginBar);
        plugin.initialize();
    });
});
