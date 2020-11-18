Public Class frmTest

    Dim game As clsGame
    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        game = New clsGame
    End Sub
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim g As Graphics = picCanvas.CreateGraphics()
        game.Draw(g)
    End Sub

End Class
