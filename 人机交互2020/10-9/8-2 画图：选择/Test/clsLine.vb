Public Class clsLine
    Private sv As clsVertex, ev As clsVertex

    Public Sub New(ByVal sv As clsVertex, ByVal ev As clsVertex)
        Me.sv = sv
        Me.ev = ev
    End Sub
    Sub Draw(ByVal g As Graphics)
        g.DrawLine(Pens.Black, sv.x, sv.y, ev.x, ev.y)
        sv.Draw(g)
        ev.Draw(g)
    End Sub
End Class
