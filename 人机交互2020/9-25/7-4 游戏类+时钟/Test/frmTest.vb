Public Class frmTest

    Dim WithEvents game As clsGame

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        game = New clsGame
    End Sub
    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        game.Start()
    End Sub

    Private Sub game_HasChanged() Handles game.HasChanged
        Dim g As Graphics = picCanvas.CreateGraphics()
        g.Clear(Color.Wheat)
        game.Draw(g)
    End Sub
End Class
