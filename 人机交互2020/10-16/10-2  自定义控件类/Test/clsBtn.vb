Public Class clsBtn
    Private Const width As Integer = 50
    Public WithEvents Btn As System.Windows.Forms.Button
    Private x As Integer, y As Integer
    Private k As Integer

    Sub New(ByVal x As Integer, ByVal y As Integer, ByVal k As Integer)
        Btn = New System.Windows.Forms.Button()
        Btn.Location = New System.Drawing.Point(x, y)
        Btn.Name = "myBtn" & k
        Btn.Size = New System.Drawing.Size(width, width)
        Btn.Text = k
    End Sub

    Private Sub Btn_Click(ByVal sender As Object, ByVal e As System.EventArgs) Handles Btn.Click
        Dim it As Button = sender
        MsgBox(it.Name)
    End Sub
End Class
