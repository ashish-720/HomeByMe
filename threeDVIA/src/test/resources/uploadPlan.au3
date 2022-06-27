WinActivate("Choose file");
Local $file = "c:\yourpath\howtoupload.doc"
ControlSetText("Choose file", "", "Edit1", $file )
ControlClick("Choose file", "", "Button2")