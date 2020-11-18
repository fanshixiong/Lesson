Public Class frmTest
    Dim box As clsBox
    Dim ball As clsBall

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        box = New clsBox(200, 200, 300, 400)
        ball = New clsBall(100, 100, 5)
    End Sub
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim g As Graphics = picCanvas.CreateGraphics()
        ball.Draw(g)
        box.Draw(g)
    End Sub

End Class
