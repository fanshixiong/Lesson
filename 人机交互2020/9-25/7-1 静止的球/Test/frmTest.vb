Public Class frmTest
    Dim ball As clsBall

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        ball = New clsBall(100, 100, 5)
    End Sub
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        ball.Draw(picCanvas.CreateGraphics())
    End Sub

End Class
