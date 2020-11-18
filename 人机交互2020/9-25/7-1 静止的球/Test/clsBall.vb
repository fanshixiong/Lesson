Public Class clsBall
    Private x As Single, y As Single, r As Single

    Public Sub New(ByVal x As Single, ByVal y As Single, ByVal r As Single)
        Me.x = x : Me.y = y : Me.r = r
    End Sub

    Public Sub Draw(ByVal g As Graphics)
        g.DrawEllipse(Pens.Black, x - r, y - r, 2 * r, 2 * r)
    End Sub

End Class
