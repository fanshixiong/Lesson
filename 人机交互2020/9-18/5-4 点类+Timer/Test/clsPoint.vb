Public Class clsPoint
    Private x As Single, y As Single
    Private lastx As Single, lasty As Single

    Public Sub New(ByVal x As Single, ByVal y As Single)
        Me.x = x : Me.y = y
        lastx = x : lasty = y
    End Sub
    Sub Move(ByVal dx As Single, ByVal dy As Single)
        x += dx : y += dy
    End Sub
    Sub MoveTo(ByVal x As Single, ByVal y As Single)
        lastx = x : lasty = y
    End Sub
    Sub LineTo(ByVal x As Single, ByVal y As Single)
        Me.x = x : Me.y = y
    End Sub
    Sub Draw(ByVal g As Graphics)
        g.DrawLine(Pens.Black, lastx, lasty, x, y)
        g.DrawEllipse(Pens.Black, x - 2, y - 2, 4, 4)
        lastx = x : lasty = y
    End Sub



End Class
