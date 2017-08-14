package com.metl.data

import com.metl.utils._

class SerializationNotImplementedException extends Exception("Serializer has not implemented this method")

abstract class Serializer {
  type T <: Object
  def fromRenderableHistory(input:History):List[T] = input.getRenderable.map(i => fromMeTLData(i)).toList
  def fromHistory(input:History):T = throw new SerializationNotImplementedException
  def toHistory(input:T):History = throw new SerializationNotImplementedException
  def toMeTLData(input:T):MeTLData = throw new SerializationNotImplementedException
  def toMeTLMoveDelta(input:T):MeTLMoveDelta = throw new SerializationNotImplementedException
  def fromMeTLMoveDelta(input:MeTLMoveDelta):T = throw new SerializationNotImplementedException
  def toMeTLAttendance(input:T):Attendance = throw new SerializationNotImplementedException
  def fromMeTLAttendance(input:Attendance):T = throw new SerializationNotImplementedException
  def toMeTLInk(input:T):MeTLInk = throw new SerializationNotImplementedException
  def fromMeTLInk(input:MeTLInk):T = throw new SerializationNotImplementedException
  def toMeTLImage(input:T):MeTLImage = throw new SerializationNotImplementedException
  def toMeTLImage(input:T,imageData:Array[Byte]):MeTLImage = throw new SerializationNotImplementedException
  def fromMeTLImage(input:MeTLImage):T = throw new SerializationNotImplementedException
  def toMeTLVideo(input:T):MeTLVideo = throw new SerializationNotImplementedException
  def toMeTLVideo(input:T,videoData:Array[Byte]):MeTLVideo = throw new SerializationNotImplementedException
  def fromMeTLVideo(input:MeTLVideo):T = throw new SerializationNotImplementedException
  def toMeTLDirtyVideo(input:T):MeTLDirtyVideo = throw new SerializationNotImplementedException
  def fromMeTLDirtyVideo(input:MeTLDirtyVideo):T = throw new SerializationNotImplementedException
  def toMeTLText(input:T):MeTLText = throw new SerializationNotImplementedException
  def fromMeTLText(input:MeTLText):T = throw new SerializationNotImplementedException
  def toMeTLWord(input:T):MeTLTextWord = throw new SerializationNotImplementedException
  def fromMeTLWord(input:MeTLTextWord):T = throw new SerializationNotImplementedException
  def toMeTLMultiWordText(input:T):MeTLMultiWordText = throw new SerializationNotImplementedException
  def fromMeTLMultiWordText(input:MeTLMultiWordText):T = throw new SerializationNotImplementedException
  def toMeTLDirtyInk(input:T):MeTLDirtyInk = throw new SerializationNotImplementedException
  def fromMeTLDirtyInk(input:MeTLDirtyInk):T = throw new SerializationNotImplementedException
  def toMeTLDirtyImage(input:T):MeTLDirtyImage = throw new SerializationNotImplementedException
  def fromMeTLDirtyImage(input:MeTLDirtyImage):T = throw new SerializationNotImplementedException
  def toMeTLDirtyText(input:T):MeTLDirtyText = throw new SerializationNotImplementedException
  def fromMeTLDirtyText(input:MeTLDirtyText):T = throw new SerializationNotImplementedException
  def toMeTLCommand(input:T):MeTLCommand = throw new SerializationNotImplementedException
  def fromMeTLCommand(input:MeTLCommand):T = throw new SerializationNotImplementedException
  def toSubmission(input:T):MeTLSubmission = throw new SerializationNotImplementedException
  def toSubmission(input:T,imageData:Array[Byte]):MeTLSubmission = throw new SerializationNotImplementedException
  def fromSubmission(input:MeTLSubmission):T = throw new SerializationNotImplementedException
  def toMeTLQuiz(input:T):MeTLQuiz = throw new SerializationNotImplementedException
  def toMeTLQuiz(input:T,imageData:Array[Byte]):MeTLQuiz = throw new SerializationNotImplementedException
  def fromMeTLQuiz(input:MeTLQuiz):T = throw new SerializationNotImplementedException
  def toMeTLQuizResponse(input:T):MeTLQuizResponse = throw new SerializationNotImplementedException
  def fromMeTLQuizResponse(input:MeTLQuizResponse):T = throw new SerializationNotImplementedException
  def toMeTLFile(input:T):MeTLFile = throw new SerializationNotImplementedException
  def toMeTLFile(input:T,bytes:Array[Byte]):MeTLFile = throw new SerializationNotImplementedException
  def fromMeTLFile(input:MeTLFile):T = throw new SerializationNotImplementedException
  def toMeTLVideoStream(input:T):MeTLVideoStream = throw new SerializationNotImplementedException
  def fromMeTLVideoStream(input:MeTLVideoStream):T = throw new SerializationNotImplementedException
  def toConversation(input:T):Conversation = throw new SerializationNotImplementedException
  def fromConversation(input:Conversation):T = throw new SerializationNotImplementedException
  def fromConversationList(input:List[Conversation]):T = throw new SerializationNotImplementedException
  def toSlide(input:T):Slide = throw new SerializationNotImplementedException
  def fromSlide(input:Slide):T = throw new SerializationNotImplementedException
  def toGroupSet(input:T):GroupSet = throw new SerializationNotImplementedException
  def fromGroupSet(input:GroupSet):T = throw new SerializationNotImplementedException
  def toGroup(input:T):Group = throw new SerializationNotImplementedException
  def fromGroup(input:Group):T = throw new SerializationNotImplementedException
  def toGroupingStrategy(input:T):GroupingStrategy = throw new SerializationNotImplementedException
  def fromGroupingStrategy(input:GroupingStrategy):T = throw new SerializationNotImplementedException
  def toPermissions(input:T):Permissions = throw new SerializationNotImplementedException
  def fromPermissions(input:Permissions):T = throw new SerializationNotImplementedException
  def toPoint(input:AnyRef):Point = throw new SerializationNotImplementedException
  def fromPoint(input:Point):AnyRef = throw new SerializationNotImplementedException
  def toPointList(input:AnyRef):List[Point] = throw new SerializationNotImplementedException
  def fromPointList(input:List[Point]):AnyRef = throw new SerializationNotImplementedException
  def toColor(input:AnyRef):Color = throw new SerializationNotImplementedException
  def fromColor(input:Color):AnyRef = throw new SerializationNotImplementedException
  def toMeTLUndeletedCanvasContent(input:T):MeTLUndeletedCanvasContent = throw new SerializationNotImplementedException
  def fromMeTLUndeletedCanvasContent(input:MeTLUndeletedCanvasContent):T = throw new SerializationNotImplementedException
  def toMeTLUnhandledStanza(input:T):MeTLUnhandledStanza = throw new SerializationNotImplementedException
  def fromMeTLUnhandledStanza(input:MeTLUnhandledStanza):T = throw new SerializationNotImplementedException
  def toMeTLUnhandledData(input:T):MeTLUnhandledData = throw new SerializationNotImplementedException
  def fromMeTLUnhandledData(input:MeTLUnhandledData):T = throw new SerializationNotImplementedException
  def toMeTLUnhandledCanvasContent(input:T):MeTLUnhandledCanvasContent = throw new SerializationNotImplementedException
  def fromMeTLUnhandledCanvasContent(input:MeTLUnhandledCanvasContent):T = throw new SerializationNotImplementedException
  def toTheme(input:T):MeTLTheme = throw new SerializationNotImplementedException
  def fromTheme(input:MeTLTheme):T = throw new SerializationNotImplementedException
  def toGrade(input:T):MeTLGrade = throw new SerializationNotImplementedException
  def fromGrade(input:MeTLGrade):T = throw new SerializationNotImplementedException
  def toNumericGradeValue(input:T):MeTLNumericGradeValue = throw new SerializationNotImplementedException
  def fromNumericGradeValue(input:MeTLNumericGradeValue):T = throw new SerializationNotImplementedException
  def toBooleanGradeValue(input:T):MeTLBooleanGradeValue = throw new SerializationNotImplementedException
  def fromBooleanGradeValue(input:MeTLBooleanGradeValue):T = throw new SerializationNotImplementedException
  def toTextGradeValue(input:T):MeTLTextGradeValue = throw new SerializationNotImplementedException
  def fromTextGradeValue(input:MeTLTextGradeValue):T = throw new SerializationNotImplementedException
  def toChatMessage(input:T):MeTLChatMessage = throw new SerializationNotImplementedException
  def fromChatMessage(input:MeTLChatMessage):T = throw new SerializationNotImplementedException
  def toProfile(input:T):Profile = throw new SerializationNotImplementedException
  def fromProfile(input:Profile):T = throw new SerializationNotImplementedException
  def fromMeTLData(input:MeTLData):T = input match {
    case i:MeTLInk => fromMeTLInk(i)
    case t:MeTLText => fromMeTLText(t)
    case t:MeTLMultiWordText => fromMeTLMultiWordText(t)
    case i:MeTLImage => fromMeTLImage(i)
    case i:MeTLVideo => fromMeTLVideo(i)
    case d:MeTLDirtyInk => fromMeTLDirtyInk(d)
    case d:MeTLDirtyText => fromMeTLDirtyText(d)
    case d:MeTLDirtyImage => fromMeTLDirtyImage(d)
    case d:MeTLDirtyVideo => fromMeTLDirtyVideo(d)
    case c:MeTLCommand => fromMeTLCommand(c)
    case q:MeTLQuiz => fromMeTLQuiz(q)
    case qr:MeTLQuizResponse => fromMeTLQuizResponse(qr)
    case s:MeTLSubmission => fromSubmission(s)
    case m:MeTLMoveDelta => fromMeTLMoveDelta(m)
    case a:Attendance => fromMeTLAttendance(a)
    case f:MeTLFile => fromMeTLFile(f)
    case v:MeTLVideoStream => fromMeTLVideoStream(v)
    case t:MeTLTheme => fromTheme(t)
    case g:MeTLGrade => fromGrade(g)
    case g:MeTLNumericGradeValue => fromNumericGradeValue(g)
    case g:MeTLBooleanGradeValue => fromBooleanGradeValue(g)
    case g:MeTLTextGradeValue => fromTextGradeValue(g)
    case cm:MeTLChatMessage => fromChatMessage(cm)
    case p:Profile => fromProfile(p)
    case uc:MeTLUndeletedCanvasContent => fromMeTLUndeletedCanvasContent(uc)
    case cc:MeTLUnhandledCanvasContent => fromMeTLUnhandledCanvasContent(cc)
    case ms:MeTLUnhandledStanza => fromMeTLUnhandledStanza(ms)
    case mx:MeTLUnhandledData => fromMeTLUnhandledData(mx)
    case _ => throw new SerializationNotImplementedException
  }
}

class PassthroughSerializer extends Serializer {
  type T = Object
  override def toMeTLData(input:Object):MeTLData = input.asInstanceOf[MeTLData]
  override def fromMeTLData(input:MeTLData):Object = input.asInstanceOf[Object]
  override def toMeTLAttendance(input:T):Attendance = input.asInstanceOf[Attendance]
  override def fromMeTLAttendance(input:Attendance):T = input.asInstanceOf[Object]
  override def toMeTLInk(input:Object):MeTLInk = input.asInstanceOf[MeTLInk]
  override def fromMeTLInk(input:MeTLInk):Object = input.asInstanceOf[Object]
  override def toMeTLImage(input:Object):MeTLImage = input.asInstanceOf[MeTLImage]
  override def toMeTLImage(input:Object,imageData:Array[Byte]):MeTLImage = input.asInstanceOf[MeTLImage]
  override def fromMeTLImage(input:MeTLImage):Object = input.asInstanceOf[Object]
  override def toMeTLVideo(input:Object):MeTLVideo = input.asInstanceOf[MeTLVideo]
  override def toMeTLVideo(input:Object,videoData:Array[Byte]):MeTLVideo = input.asInstanceOf[MeTLVideo]
  override def fromMeTLVideo(input:MeTLVideo):Object = input.asInstanceOf[Object]
  override def toMeTLText(input:Object):MeTLText = input.asInstanceOf[MeTLText]
  override def fromMeTLText(input:MeTLText):Object = input.asInstanceOf[Object]
  override def toMeTLMoveDelta(input:Object):MeTLMoveDelta = input.asInstanceOf[MeTLMoveDelta]
  override def fromMeTLMoveDelta(input:MeTLMoveDelta):Object = input.asInstanceOf[Object]
  override def toMeTLDirtyInk(input:Object):MeTLDirtyInk = input.asInstanceOf[MeTLDirtyInk]
  override def fromMeTLDirtyInk(input:MeTLDirtyInk):Object = input.asInstanceOf[Object]
  override def toMeTLDirtyImage(input:Object):MeTLDirtyImage = input.asInstanceOf[MeTLDirtyImage]
  override def fromMeTLDirtyImage(input:MeTLDirtyImage):Object = input.asInstanceOf[Object]
  override def toMeTLDirtyVideo(input:Object):MeTLDirtyVideo = input.asInstanceOf[MeTLDirtyVideo]
  override def fromMeTLDirtyVideo(input:MeTLDirtyVideo):Object = input.asInstanceOf[Object]
  override def toMeTLDirtyText(input:Object):MeTLDirtyText = input.asInstanceOf[MeTLDirtyText]
  override def fromMeTLDirtyText(input:MeTLDirtyText):Object = input.asInstanceOf[Object]
  override def toMeTLCommand(input:Object):MeTLCommand = input.asInstanceOf[MeTLCommand]
  override def fromMeTLCommand(input:MeTLCommand):Object = input.asInstanceOf[Object]
  override def toSubmission(input:Object):MeTLSubmission = input.asInstanceOf[MeTLSubmission]
  override def toSubmission(input:Object,imageData:Array[Byte]):MeTLSubmission = input.asInstanceOf[MeTLSubmission]
  override def fromSubmission(input:MeTLSubmission):Object = input.asInstanceOf[Object]
  override def toMeTLQuiz(input:Object):MeTLQuiz = input.asInstanceOf[MeTLQuiz]
  override def toMeTLQuiz(input:Object,imageData:Array[Byte]):MeTLQuiz = input.asInstanceOf[MeTLQuiz]
  override def fromMeTLQuiz(input:MeTLQuiz):Object = input.asInstanceOf[Object]
  override def fromTheme(input:MeTLTheme):Object = input.asInstanceOf[Object]
  override def toTheme(input:Object):MeTLTheme = input.asInstanceOf[MeTLTheme]
  override def fromChatMessage(input:MeTLChatMessage):Object = input.asInstanceOf[Object]
  override def toChatMessage(input:Object):MeTLChatMessage = input.asInstanceOf[MeTLChatMessage]
  override def toMeTLQuizResponse(input:Object):MeTLQuizResponse = input.asInstanceOf[MeTLQuizResponse]
  override def fromMeTLQuizResponse(input:MeTLQuizResponse):Object = input.asInstanceOf[Object]
  override def toMeTLFile(input:T):MeTLFile = input.asInstanceOf[MeTLFile]
  override def toMeTLFile(input:T,bytes:Array[Byte]):MeTLFile = input.asInstanceOf[MeTLFile]
  override def fromMeTLFile(input:MeTLFile):T = input.asInstanceOf[Object]
  override def toMeTLVideoStream(input:T):MeTLVideoStream = input.asInstanceOf[MeTLVideoStream]
  override def fromMeTLVideoStream(input:MeTLVideoStream):T = input.asInstanceOf[Object]
  override def toConversation(input:Object):Conversation = input.asInstanceOf[Conversation]
  override def fromConversation(input:Conversation):Object = input.asInstanceOf[Object]
  override def toSlide(input:Object):Slide = input.asInstanceOf[Slide]
  override def fromSlide(input:Slide):Object = input.asInstanceOf[Object]
  override def toGroupSet(input:T):GroupSet = input.asInstanceOf[GroupSet]
  override def fromGroupSet(input:GroupSet):T = input.asInstanceOf[Object]
  override def toGroup(input:T):Group = input.asInstanceOf[Group]
  override def fromGroup(input:Group):T = input.asInstanceOf[Object]
  override def toGroupingStrategy(input:T):GroupingStrategy = input.asInstanceOf[GroupingStrategy]
  override def fromGroupingStrategy(input:GroupingStrategy):T = input.asInstanceOf[Object]
  override def toPermissions(input:Object):Permissions = input.asInstanceOf[Permissions]
  override def fromPermissions(input:Permissions):Object = input.asInstanceOf[Object]
  override def toPoint(input:AnyRef):Point = input.asInstanceOf[Point]
  override def fromPoint(input:Point):AnyRef = input.asInstanceOf[AnyRef]
  override def toPointList(input:AnyRef):List[Point] = input.asInstanceOf[List[Point]]
  override def fromPointList(input:List[Point]):AnyRef = input.asInstanceOf[AnyRef]
  override def toColor(input:AnyRef):Color = input.asInstanceOf[Color]
  override def fromColor(input:Color):AnyRef = input.asInstanceOf[AnyRef]
  override def toMeTLUnhandledData(input:AnyRef):MeTLUnhandledData = input.asInstanceOf[MeTLUnhandledData]
  override def fromMeTLUnhandledData(input:MeTLUnhandledData):T = input.asInstanceOf[Object]
  override def toMeTLUnhandledStanza(input:AnyRef):MeTLUnhandledStanza = input.asInstanceOf[MeTLUnhandledStanza]
  override def fromMeTLUnhandledStanza(input:MeTLUnhandledStanza):T = input.asInstanceOf[Object]
  override def toMeTLUnhandledCanvasContent(input:AnyRef):MeTLUnhandledCanvasContent = input.asInstanceOf[MeTLUnhandledCanvasContent]
  override def fromMeTLUnhandledCanvasContent(input:MeTLUnhandledCanvasContent):T = input.asInstanceOf[Object]
  override def toMeTLUndeletedCanvasContent(input:T):MeTLUndeletedCanvasContent = input.asInstanceOf[MeTLUndeletedCanvasContent]
  override def fromMeTLUndeletedCanvasContent(input:MeTLUndeletedCanvasContent):T = input.asInstanceOf[Object]
  override def toGrade(input:Object):MeTLGrade = input.asInstanceOf[MeTLGrade]
  override def fromGrade(input:MeTLGrade):Object = input.asInstanceOf[Object]
  override def toNumericGradeValue(input:Object):MeTLNumericGradeValue = input.asInstanceOf[MeTLNumericGradeValue]
  override def fromNumericGradeValue(input:MeTLNumericGradeValue):Object = input.asInstanceOf[Object]
  override def toBooleanGradeValue(input:Object):MeTLBooleanGradeValue = input.asInstanceOf[MeTLBooleanGradeValue]
  override def fromBooleanGradeValue(input:MeTLBooleanGradeValue):Object = input.asInstanceOf[Object]
  override def toTextGradeValue(input:Object):MeTLTextGradeValue = input.asInstanceOf[MeTLTextGradeValue]
  override def fromTextGradeValue(input:MeTLTextGradeValue):Object = input.asInstanceOf[Object]
  override def toProfile(input:Object):Profile = input.asInstanceOf[Profile]
  override def fromProfile(input:Profile):Object = input.asInstanceOf[Object]
}
