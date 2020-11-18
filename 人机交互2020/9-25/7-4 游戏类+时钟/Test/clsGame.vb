Public Class clsGame
    Private box As clsBox
    Private ball As clsBall
    Private WithEvents ticker As Timer
    Public Event HasChanged()

    Public Sub New()
        box = New clsBox(200, 200, 300, 400)
        ball = New clsBall(100, 100, 5, 2.5, 1.5)
        ticker = New Timer
        ticker.Interval = 100
        ticker.Enabled = False
    End Sub
    Public Sub Start()
        ticker.Enabled = True
    End Sub
    Private Sub ticker_Tick(ByVal sender As Object, ByVal e As System.EventArgs) Handles ticker.Tick
        ball.Move(box)
        RaiseEvent HasChanged()
    End Sub

    Public Sub Draw(ByVal g As Graphics)
        ball.Draw(g)
        box.Draw(g)
    End Sub

End Class
