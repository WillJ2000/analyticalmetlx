# MeTL

## Description

This project provides the primary MeTL server, the high interaction comet-enabled javascript product (available at `/board`).  This is developed in Scala, and deploys as a WAR directly into a Java web container.  We've been using Jetty (which is embedded for development, but the WAR can be dropped into any Java servlet container).

## Installation

- Install the following required tools:
  - [Java](www.oracle.com/technetwork/java/javase/downloads) JDK version 8.x
  - [NPM](https://www.npmjs.com/get-npm) (Node Package Manager)
- Clone MeTL `git clone https://github.com/StackableRegiments/analyticalmetlx.git`

## Configure

Before running the application, there are a few configuration settings you'll need to set.  These are set by the files outside the WAR, and examples of the files are available in the config directory (eg `configuration.sample.xml`).

The following Java system properties can be provided at the command line (see `sbt.bat` and `sbt.sh`):

### SBT

We use SBT to compile and publish this app. It is included in the repo as `sbt-launcher.jar`.

Set the location of SBT files and directories.

- `sbt.boot.directory="%IVY_HOME%\.sbt-boot"`
- `sbt.global.home="%IVY_HOME%\.sbt"`
- `sbt.home="%IVY_HOME%\.sbt"`
- `sbt.ivy.home="%IVY_HOME%\.ivy2\"`
- `sbt.global.staging="%IVY_HOME%\.sbt-staging"`

### MeTL

- `metlx.configurationFile="./config/configuration.local.xml"` sets the location of the MeTL config file.

See [README-config.md](README-config.md) for more detail.

### Logback

MeTL uses Logback, which can be overridden to use a config file from outside the WAR.

- `logback.configurationFile="config/logback.xml"` sets the location of the Logback config file.

See [Logback](https://logback.qos.ch/manual/index.html) for more detail.

### Developer Options

- `run.mode="development"` instructs Lift to disable most caching (see [Simply Lift](https://simply.liftweb.net/index-3.1.html#toc-Subsection-3.1.2)).
- `metl.stopwatch.enabled="true"` enables duration logging of various actions.
- `metl.stopwatch.minimumLog="1000"` requires that an action take longer than 1s before it is logged.
- `stackable.spending=enabled` enables use of third-party services defined in [README-config.md](README-config.md). This will also require configuring access credentials for each service.

## Run

To run a local (development) server for this app, use:

    $ sbt container:start

Other useful commands include: `sbt container:stop` and `sbt container:restart`.

## Deployment

This project publishes to a WAR file.

Use sbt's `deploy` goal to create the warfile:

    $ sbt deploy

and then copy it from `/target/scala-2.10/` to the container of your choice.

### CSS (optional)

If any styles have changed (.less) then first compile to CSS using Grunt  (on Mac/Linux):

    $ ./grunt.sh

or (on Windows):

    > grunt-run.bat

If this is a fresh checkout then (on Mac/Linux) you'll first need to make the shell script executable: `chmod u+x grunt.sh`

### Javascript (optional)

If any Javascript has changed (.js) then first re-minify (on Mac/Linux):

    $ ./minify.sh

or (on Windows):

    > minify.bat

If this is a fresh checkout then (on Mac/Linux) you'll first need to make the shell script executable first: `chmod u+x minify.sh`

### Testing

MeTL has a CI pipeline on CircleCI, at:

[https://circleci.com/gh/StackableRegiments/analyticalmetlx]

<!DOCTYPE html>
<html>
<head>
	<title>MeTl Text Editor</title>
    <style>
    div#textEditor{
	margin: 0 auto;
	width: 750px;
	height: 300px;
}
div#theRibbon{
	border-bottom: none;
	padding: 10px;
	background-color: rgb(40,110,89);
	color: white;
	border-radius: 8px 8px 0px 0px;
}
div#richTextArea{
	border: 2px solid rgb(40,110,89);
	height: 100%;
	width: 746px;
}
iframe#theWYSIWYG{
	height: 100%;
	width: 100%;
}
div#theRibbon > button {
	color: white;
    border: none;
    outline: none;
    background-color: transparent;
    cursor: pointer;
   }
   div#theRibbon > button: hover{
   	background-color: rgb(20,90,70);
    transition: all 0.3s linear 0s;
    }
    input[type="color"]{
    border:none;
    outline: none;
    background-color: transparent;
    }
	</style>
	<script>
		window.addEventListener("load",function(){
			var editor = theWYSIWYG.document;
			editor.designMode = "on";
			
			boldButton.addEventListener("click", function(){
			editor.execCommand("Bold", false, null);
			},false);
			
			italicButton.addEventListener("click", function(){
			editor.execCommand("Italic", false, null);
			},false);
			
			supButton.addEventListener("click", function(){
				editor.execCommand("Superscript", false, null);
			},false);
		
			subButton.addEventListener("click", function(){
				editor.execCommand("Subscript", false, null);
			},false);
			
			strikeButton.addEventListener("click", function(){
				editor.execCommand("Strikethrough", false, null);
			},false);
		
			orderedListButton.addEventListener("click", function(){
				editor.execCommand("InsertOrderedList", false, "newOL" + Math.round(Math.random() * 1000));
			},false);
		
			unorderedListButton.addEventListener("click", function(){
				editor.execCommand("InsertUnOrderedList", false, "newOL" + Math.round(Math.random() * 1000));
			},false);
			
			fontColorButton.addEventListener("change", function(event){
				editor.execCommand("ForeColor", false, event.target.value);
			},false);

			highlightButton.addEventListener("change", function(event){
				editor.execCommand("BackColor", false, event.target.value);
			},false);
		
			fontChanger.addEventListener("change", function(event){
				editor.execCommand("FontName", false, event.target.value);
			},false);	
	
			fontSizeChanger.addEventListener("change", function(event){
				editor.execCommand("FontSize", false, event.target.value);
			},false);	
				
			linkButton.addEventListener("click", function(){
				var url = prompt("Enter a URL", "http://");
				editor.execCommand("CreateLink", false, url);
			},false);
	
			unLinkButton.addEventListener("click", function(){
				editor.execCommand("UnLink", false, null);
			},false);
	
			undoButton.addEventListener("click", function(){
				editor.execCommand("undo",false,null);
			},false);
			
			redoButton.addEventListener("click", function(){
				editor.execCommand("redo",false,null);
			},false);
			
	},false);
	
	
		
	</script>
</head>
<body>
	<div id="textEditor">
		<div id="theRibbon"> 
		<button id="boldButton" title="Bold"><b>B</b></button>
			<button id="italicButton" title="Italic"><i>I</i></button>
			<button id="supButton" title="Superscript">X<sup>2</sup></button>
			<button id="subButton" title="Subscript">X<sub>2</sub></button>
			<button id="strikeButton" title="Strikethrough"><s>abc</s></button>
			<button id="orderedListButton" title="Numbered List">(1)</button>
			<button id="unorderedListButton" title="Bullet List">&bull;</button>
            <input type="color" id="fontColorButton" title="Change Font Color">
			<input type="color" id="highlightButton" title="Highlight Text">
            <select id="fontChanger">
				<option value="Times New Roman">Times New Roman</option>
				<option value="Consolas">Consolas</option>
				<option value="Tahoma">Tahoma</option>
				<option value="monospace">Monospace</option>
				<option value="cursive">Cursive</option>
				<option value="sans-serif">Sans-Serif</option>
				<option value="Calibri">Calibri</option>
			</select>            
			<select id="fontSizeChanger">
				<script>
					for(var i = 1; i < 10; i++){
						document.write("<option value='"+i+"'>"+i+ "</option>");
					}
				</script>
			</select>        
			<button id="linkButton" title="Create Link">Link</button>
			<button id="unlinkButton" title="Remove Link">Unlink</button>
			<button id="undoButton" title="Undo the previous action">&larr;</button>
			<button id="redoButton" title="Redo">&rarr;</button>
		</div>
		<div id="richTextArea">
			<iframe id="theWYSIWYG" name="theWYSIWYG" frameborder="0"> </iframe>            
   		 </div>
	</div>
	<script>
		var fonts = document.querySelectorAll ("select#fontChanger > option");
		for (var i = 0; i < fonts.length; i++){
			fonts[i].style.fontFamily = fonts[i].value;
			}
			</script>
</body>
</html>
